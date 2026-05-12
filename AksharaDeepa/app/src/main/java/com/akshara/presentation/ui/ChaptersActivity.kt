package com.akshara.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshara.R
import com.akshara.data.database.AksharaDatabase
import com.akshara.domain.repository.AksharaRepository
import com.akshara.presentation.viewmodel.MainViewModel
import com.akshara.presentation.viewmodel.MainViewModelFactory

class ChaptersActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ChapterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapters)

        val subjectId = intent.getIntExtra("subject_id", -1)
        val subjectName = intent.getStringExtra("subject_name") ?: "Chapters"

        findViewById<TextView>(R.id.subjectTitle).text = subjectName

        val dao = AksharaDatabase.getDatabase(this).aksharaDao()
        val repository = AksharaRepository(dao)
        val factory = MainViewModelFactory(repository, dao)
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        recyclerView = findViewById(R.id.chaptersRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        
        adapter = ChapterAdapter(
            onStudyClick = { chapter ->
                val intent = Intent(this, StudyGuideActivity::class.java)
                intent.putExtra("chapter_id", chapter.id)
                intent.putExtra("chapter_title", chapter.title)
                startActivity(intent)
            },
            onQuizClick = { chapter ->
                val intent = Intent(this, QuizActivity::class.java)
                intent.putExtra("chapter_id", chapter.id)
                intent.putExtra("chapter_title", chapter.title)
                startActivity(intent)
            }
        )
        recyclerView.adapter = adapter
        
        repository.getChaptersForSubject(subjectId).asLiveData().observe(this) { chapters ->
            adapter.submitList(chapters)
        }
    }
}
