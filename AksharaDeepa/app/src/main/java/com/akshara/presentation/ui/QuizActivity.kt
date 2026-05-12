package com.akshara.presentation.ui

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.akshara.R
import com.akshara.data.database.AksharaDatabase
import com.akshara.domain.repository.AksharaRepository
import com.akshara.presentation.viewmodel.QuizViewModel
import com.akshara.presentation.viewmodel.QuizViewModelFactory
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

class QuizActivity : AppCompatActivity() {

    private lateinit var viewModel: QuizViewModel
    private lateinit var questionText: TextView
    private lateinit var questionNumber: TextView
    private lateinit var timerText: TextView
    private lateinit var optionA: MaterialButton
    private lateinit var optionB: MaterialButton
    private lateinit var optionC: MaterialButton
    private lateinit var optionD: MaterialButton
    private lateinit var btnNext: MaterialButton
    private lateinit var explanationCard: MaterialCardView
    private lateinit var explanationText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val chapterId = intent.getIntExtra("chapter_id", -1)

        // UI Initialization
        questionText = findViewById(R.id.questionText)
        questionNumber = findViewById(R.id.questionNumber)
        timerText = findViewById(R.id.quizTimer)
        optionA = findViewById(R.id.optionA)
        optionB = findViewById(R.id.optionB)
        optionC = findViewById(R.id.optionC)
        optionD = findViewById(R.id.optionD)
        
        btnNext = findViewById(R.id.btnNextQuestion)
        explanationCard = findViewById(R.id.explanationCard)
        explanationText = findViewById(R.id.explanationText)

        // ViewModel
        val dao = AksharaDatabase.getDatabase(this).aksharaDao()
        val repository = AksharaRepository(dao)
        val factory = QuizViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[QuizViewModel::class.java]

        viewModel.startQuiz(chapterId)

        // Observers
        viewModel.currentQuestion.observe(this) { question ->
            question?.let {
                questionText.text = it.text
                optionA.text = it.optionA
                optionB.text = it.optionB
                optionC.text = it.optionC
                optionD.text = it.optionD
                
                questionNumber.text = viewModel.getQuestionProgressText()
                
                explanationCard.visibility = View.GONE
                btnNext.visibility = View.GONE
                resetOptionStyles()
            }
        }

        viewModel.isLastQuestion.observe(this) { isLast ->
            if (isLast) {
                btnNext.text = "SUBMIT"
            } else {
                btnNext.text = "Next Question"
            }
        }

        viewModel.timeRemaining.observe(this) { time ->
            timerText.text = "00:${String.format("%02d", time)}"
            if (time <= 5) {
                timerText.setTextColor(Color.RED)
            } else {
                timerText.setTextColor(Color.parseColor("#4A5568"))
            }
        }

        viewModel.isQuizFinished.observe(this) { finished ->
            if (finished) {
                showResultDialog()
            }
        }

        viewModel.isTimeUpEvent.observe(this) { timeUp ->
            if (timeUp == true) {
                handleAnswer(' ') // Show correct answer if time runs out
                Toast.makeText(this, "Time's up!", Toast.LENGTH_SHORT).show()
            }
        }

        optionA.setOnClickListener { handleAnswer('A') }
        optionB.setOnClickListener { handleAnswer('B') }
        optionC.setOnClickListener { handleAnswer('C') }
        optionD.setOnClickListener { handleAnswer('D') }
        
        btnNext.setOnClickListener {
            viewModel.nextQuestion()
        }
    }

    private fun handleAnswer(selected: Char) {
        viewModel.submitAnswer(selected)
        val currentQ = viewModel.currentQuestion.value
        val correct = currentQ?.correctOption
        explanationText.text = currentQ?.explanation
        explanationCard.visibility = View.VISIBLE
        btnNext.visibility = View.VISIBLE
        
        // Disable buttons to prevent multiple clicks
        optionA.isEnabled = false
        optionB.isEnabled = false
        optionC.isEnabled = false
        optionD.isEnabled = false

        // Highlight correct and wrong answers
        highlightButtons(selected, correct)
    }

    private fun highlightButtons(selected: Char, correct: Char?) {
        val green = ColorStateList.valueOf(Color.parseColor("#C6F6D5"))
        val red = ColorStateList.valueOf(Color.parseColor("#FED7D7"))
        val strokeGreen = Color.parseColor("#38A169")
        val strokeRed = Color.parseColor("#E53E3E")

        val optionsMap = mapOf('A' to optionA, 'B' to optionB, 'C' to optionC, 'D' to optionD)

        // Highlight correct one in Green
        optionsMap[correct?.uppercaseChar()]?.apply {
            backgroundTintList = green
            strokeColor = ColorStateList.valueOf(strokeGreen)
        }

        // If user picked wrong, highlight in Red
        val upperSelected = selected.uppercaseChar()
        if (upperSelected != ' ' && upperSelected != correct?.uppercaseChar()) {
            optionsMap[upperSelected]?.apply {
                backgroundTintList = red
                strokeColor = ColorStateList.valueOf(strokeRed)
            }
        }
    }

    private fun resetOptionStyles() {
        val white = ColorStateList.valueOf(Color.WHITE)
        val strokeGray = ColorStateList.valueOf(Color.parseColor("#E2E8F0"))
        
        val buttons = listOf(optionA, optionB, optionC, optionD)
        buttons.forEach {
            it.isEnabled = true
            it.backgroundTintList = white
            it.strokeColor = strokeGray
        }
    }

    private fun showResultDialog() {
        val score = viewModel.score.value ?: 0
        val total = viewModel.getTotalQuestions()
        val percentage = if (total > 0) (score * 100) / total else 0
        val feedback = viewModel.getFeedbackMessage(score, total)
        
        AlertDialog.Builder(this)
            .setTitle("Quiz Completed!")
            .setMessage("Your Score: $score / $total ($percentage%)\n\n$feedback")
            .setPositiveButton("Done") { _, _ ->
                finish()
            }
            .setCancelable(false)
            .show()
    }
}
