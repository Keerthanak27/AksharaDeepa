package com.akshara.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshara.R
import com.akshara.data.database.AksharaDatabase
import com.akshara.data.model.GuideData
import com.akshara.data.model.StudyGuideSection
import com.akshara.domain.repository.AksharaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudyGuideActivity : AppCompatActivity() {

    private lateinit var repository: AksharaRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_guide)

        val chapterId = intent.getIntExtra("chapter_id", -1)
        val chapterTitle = intent.getStringExtra("chapter_title") ?: "Study Guide"

        val dao = AksharaDatabase.getDatabase(this).aksharaDao()
        repository = AksharaRepository(dao)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.setNavigationOnClickListener { finish() }

        findViewById<TextView>(R.id.chapterTitleText).text = chapterTitle

        val studyGuide = GuideData.getGuideForChapter(chapterId)
        if (studyGuide != null) {
            findViewById<TextView>(R.id.subjectBadge).text = studyGuide.subject.uppercase()
            val recyclerView = findViewById<RecyclerView>(R.id.studySectionsRecyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = StudySectionAdapter(studyGuide.studyGuide)
        } else {
            Toast.makeText(this, "Study guide content not found.", Toast.LENGTH_SHORT).show()
        }

        findViewById<View>(R.id.btnMarkAsRead).setOnClickListener {
            markChapterAsRead(chapterId)
        }

        findViewById<View>(R.id.btnTakeQuiz).setOnClickListener {
            finish()
        }
    }

    private fun markChapterAsRead(chapterId: Int) {
        lifecycleScope.launch(Dispatchers.IO) {
            val chapter = repository.getChapterById(chapterId)
            if (chapter != null) {
                repository.updateChapterCompletion(chapter, true)
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@StudyGuideActivity, "Progress Saved! ✓", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }

    class StudySectionAdapter(private val sections: List<StudyGuideSection>) :
        RecyclerView.Adapter<StudySectionAdapter.ViewHolder>() {
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val icon: TextView = view.findViewById(R.id.sectionIcon)
            val title: TextView = view.findViewById(R.id.sectionTitle)
            val content: TextView = view.findViewById(R.id.sectionContent)
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_study_section, parent, false)
        )
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val s = sections[position]
            holder.icon.text = s.icon
            holder.title.text = s.title
            holder.content.text = s.content
        }
        override fun getItemCount() = sections.size
    }
}
