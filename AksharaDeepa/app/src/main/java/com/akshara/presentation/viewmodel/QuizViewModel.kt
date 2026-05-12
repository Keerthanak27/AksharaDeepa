package com.akshara.presentation.viewmodel

import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshara.data.model.Question
import com.akshara.domain.repository.AksharaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

data class UserAnswer(
    val question: Question,
    val selectedOption: Char,
    val isCorrect: Boolean
)

class QuizViewModel(private val repository: AksharaRepository) : ViewModel() {

    private val _currentQuestion = MutableLiveData<Question?>()
    val currentQuestion: LiveData<Question?> = _currentQuestion

    private val _score = MutableLiveData(0)
    val score: LiveData<Int> = _score

    private val _isQuizFinished = MutableLiveData(false)
    val isQuizFinished: LiveData<Boolean> = _isQuizFinished

    private val _timeRemaining = MutableLiveData<Int>(60)
    val timeRemaining: LiveData<Int> = _timeRemaining

    private val _isTimeUpEvent = MutableLiveData<Boolean>()
    val isTimeUpEvent: LiveData<Boolean> = _isTimeUpEvent

    private val _isLastQuestion = MutableLiveData<Boolean>(false)
    val isLastQuestion: LiveData<Boolean> = _isLastQuestion

    private val _userAnswers = MutableLiveData<List<UserAnswer>>(emptyList())
    val userAnswers: LiveData<List<UserAnswer>> = _userAnswers

    private var countdownTimer: CountDownTimer? = null
    private val mainHandler = Handler(Looper.getMainLooper())

    private var allQuestions: List<Question> = emptyList()
    private var currentChapterId: Int = -1
    private var currentQuestionIndex = 0

    fun startQuiz(chapterId: Int) {
        currentChapterId = chapterId
        _isQuizFinished.value = false
        _score.value = 0
        currentQuestionIndex = 0
        _isLastQuestion.value = false
        _userAnswers.value = emptyList()
        
        viewModelScope.launch(Dispatchers.IO) {
            val questions = repository.getQuestionsForChapter(chapterId)
            allQuestions = questions.shuffled().take(5)
            
            withContext(Dispatchers.Main) {
                if (allQuestions.isNotEmpty()) {
                    showQuestion(0)
                }
            }
        }
    }

    private fun showQuestion(index: Int) {
        currentQuestionIndex = index
        _currentQuestion.value = allQuestions[index]
        _isLastQuestion.value = index == allQuestions.size - 1
        startTimer()
    }

    fun submitAnswer(selectedOption: Char) {
        stopTimer() 
        val q = _currentQuestion.value ?: return
        val isCorrect = selectedOption.equals(q.correctOption, ignoreCase = true)
        
        if (isCorrect) {
            _score.value = (_score.value ?: 0) + 1
        }

        val currentAnswers = _userAnswers.value?.toMutableList() ?: mutableListOf()
        currentAnswers.add(UserAnswer(q, selectedOption, isCorrect))
        _userAnswers.value = currentAnswers
    }

    fun nextQuestion() {
        val nextIndex = currentQuestionIndex + 1
        if (nextIndex < allQuestions.size) {
            showQuestion(nextIndex)
        } else {
            finishQuiz()
        }
    }

    fun getQuestionProgressText(): String {
        return "Question ${currentQuestionIndex + 1} of ${allQuestions.size}"
    }
    
    fun getTotalQuestions(): Int = allQuestions.size

    fun getFeedbackMessage(score: Int, total: Int): String {
        val percentage = (score.toFloat() / total) * 100
        return when {
            percentage >= 80 -> "Excellent! You have a strong grasp of this chapter."
            percentage >= 50 -> "Good job! A little more practice and you'll be a pro."
            else -> "Needs Practice. Try reviewing the study material again."
        }
    }

    private fun startTimer() {
        stopTimer() 
        _isTimeUpEvent.value = false
        
        mainHandler.post {
            countdownTimer = object : CountDownTimer(60000L, 1000L) {
                override fun onTick(millisUntilFinished: Long) {
                    _timeRemaining.postValue((millisUntilFinished / 1000).toInt())
                }

                override fun onFinish() {
                    _timeRemaining.postValue(0)
                    _isTimeUpEvent.postValue(true)
                }
            }.start()
        }
    }

    private fun stopTimer() {
        mainHandler.post {
            countdownTimer?.cancel()
            countdownTimer = null
        }
    }

    fun finishQuiz() {
        stopTimer()
        _isQuizFinished.postValue(true)
        val finalScore = _score.value ?: 0
        
        viewModelScope.launch(Dispatchers.IO) {
            repository.submitQuizResult(
                chapterId = currentChapterId,
                score = finalScore,
                totalQuestions = allQuestions.size
            )
            repository.updateDailyStreak()
        }
    }

    override fun onCleared() {
        super.onCleared()
        stopTimer()
    }
}
