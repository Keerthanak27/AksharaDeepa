package com.akshara.presentation.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshara.R
import com.akshara.data.database.AksharaDatabase
import com.akshara.domain.repository.AksharaRepository
import com.akshara.presentation.viewmodel.MainViewModel
import com.akshara.presentation.viewmodel.MainViewModelFactory
import com.github.mikephil.charting.charts.RadarChart
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var subjectsRecyclerView: RecyclerView
    private lateinit var subjectAdapter: SubjectAdapter
    
    private lateinit var streakText: TextView
    private lateinit var goalStatusText: TextView
    private lateinit var strengthChart: RadarChart
    private lateinit var userName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        streakText = findViewById(R.id.streakText)
        goalStatusText = findViewById(R.id.goalStatusText)
        strengthChart = findViewById(R.id.strengthChart)
        subjectsRecyclerView = findViewById(R.id.subjectsRecyclerView)
        userName = findViewById(R.id.userName)

        // Setup ViewModel
        val dao = AksharaDatabase.getDatabase(this).aksharaDao()
        val repository = AksharaRepository(dao)
        val factory = MainViewModelFactory(repository, dao)
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        // Ensure data is populated in the database (First run or empty DB)
        lifecycleScope.launch {
            repository.ensureDataPopulated(applicationContext)
            repository.updateDailyStreak()
            viewModel.refreshDailyStatus()
        }

        setupRecyclerView()
        setupStrengthChart()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        subjectAdapter = SubjectAdapter { subject ->
            val intent = Intent(this, ChaptersActivity::class.java)
            intent.putExtra("subject_id", subject.id)
            intent.putExtra("subject_name", subject.name)
            startActivity(intent)
        }
        
        subjectsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = subjectAdapter
            isNestedScrollingEnabled = false // Let NestedScrollView handle it
        }
    }

    private fun setupStrengthChart() {
        strengthChart.apply {
            description.isEnabled = false
            webLineWidth = 1.5f
            webColor = Color.parseColor("#CBD5E1")
            webLineWidthInner = 1f
            webColorInner = Color.parseColor("#E2E8F0")
            webAlpha = 150
            
            xAxis.apply {
                textSize = 12f
                textColor = Color.parseColor("#64748B")
                valueFormatter = IndexAxisValueFormatter(listOf("Math", "Science", "Social"))
            }
            
            yAxis.apply {
                axisMinimum = 0f
                axisMaximum = 100f
                setDrawLabels(false)
                gridColor = Color.parseColor("#E2E8F0")
            }
            
            legend.isEnabled = false
        }
    }

    private fun observeViewModel() {
        viewModel.allSubjects.observe(this) { subjects ->
            subjectAdapter.submitList(subjects)
        }

        viewModel.userProgress.observe(this) { progress ->
            progress?.let {
                streakText.text = "🔥 ${it.dailyGoalStreak} Day Streak"
            }
        }

        viewModel.dailyQuizCount.observe(this) { count ->
            if (count > 0) {
                goalStatusText.text = "Goal Met! ✅"
                goalStatusText.setTextColor(Color.parseColor("#10B981"))
            } else {
                goalStatusText.text = "Not met yet"
                goalStatusText.setTextColor(Color.parseColor("#64748B"))
            }
        }

        // Radar Chart Data Observation
        var mScore = 0f
        var sciScore = 0f
        var socScore = 0f

        viewModel.getScoreForMath().observe(this) { score: Float? ->
            mScore = (score ?: 0f) * 100
            updateChartData(mScore, sciScore, socScore)
        }
        viewModel.getScoreForScience().observe(this) { score: Float? ->
            sciScore = (score ?: 0f) * 100
            updateChartData(mScore, sciScore, socScore)
        }
        viewModel.getScoreForSocial().observe(this) { score: Float? ->
            socScore = (score ?: 0f) * 100
            updateChartData(mScore, sciScore, socScore)
        }
    }

    private fun updateChartData(math: Float, science: Float, social: Float) {
        val entries = ArrayList<RadarEntry>()
        entries.add(RadarEntry(math))
        entries.add(RadarEntry(science))
        entries.add(RadarEntry(social))

        val dataSet = RadarDataSet(entries, "Performance")
        dataSet.color = Color.parseColor("#3B82F6")
        dataSet.fillColor = Color.parseColor("#3B82F6")
        dataSet.setDrawFilled(true)
        dataSet.fillAlpha = 50
        dataSet.lineWidth = 3f
        dataSet.isDrawHighlightCircleEnabled = true
        dataSet.setDrawHighlightIndicators(false)

        val data = RadarData(dataSet)
        data.setDrawValues(false)

        strengthChart.data = data
        strengthChart.animateXY(800, 800)
        strengthChart.invalidate()
    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshDailyStatus()
    }
}
