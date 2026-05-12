package com.akshara.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.akshara.data.dao.AksharaDao
import com.akshara.domain.repository.AksharaRepository
import kotlinx.coroutines.launch
import java.util.Calendar

class MainViewModel(private val repository: AksharaRepository, private val dao: AksharaDao) : ViewModel() {

    val allSubjects = repository.getAllSubjects().asLiveData()
    val userProgress = repository.getUserProgress().asLiveData()
    val weakChaptersAlert = repository.getWeakChapters().asLiveData()

    private val _dailyQuizCount = MutableLiveData<Int>()
    val dailyQuizCount: LiveData<Int> = _dailyQuizCount

    init {
        refreshDailyStatus()
    }

    fun refreshDailyStatus() {
        viewModelScope.launch {
            val calendar = Calendar.getInstance().apply {
                set(Calendar.HOUR_OF_DAY, 0)
                set(Calendar.MINUTE, 0)
                set(Calendar.SECOND, 0)
                set(Calendar.MILLISECOND, 0)
            }
            val count = dao.getResultsCountSince(calendar.timeInMillis)
            _dailyQuizCount.postValue(count)
        }
    }

    fun getScoreForMath(): LiveData<Float?> = repository.getSubjectStrength(1).asLiveData()
    fun getScoreForScience(): LiveData<Float?> = repository.getSubjectStrength(2).asLiveData()
    fun getScoreForSocial(): LiveData<Float?> = repository.getSubjectStrength(3).asLiveData()
}
