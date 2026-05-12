package com.akshara.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.akshara.R
import com.akshara.data.model.Chapter
import com.google.android.material.button.MaterialButton
import com.google.android.material.progressindicator.LinearProgressIndicator

class ChapterAdapter(
    private val onStudyClick: (Chapter) -> Unit,
    private val onQuizClick: (Chapter) -> Unit
) : ListAdapter<Chapter, ChapterAdapter.ChapterViewHolder>(ChapterDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chapter_card, parent, false)
        return ChapterViewHolder(view, onStudyClick, onQuizClick)
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ChapterViewHolder(
        itemView: View,
        private val onStudyClick: (Chapter) -> Unit,
        private val onQuizClick: (Chapter) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        
        private val titleTextView: TextView = itemView.findViewById(R.id.chapterTitle)
        private val statusTextView: TextView = itemView.findViewById(R.id.chapterStatus)
        private val progressIndicator: LinearProgressIndicator = itemView.findViewById(R.id.chapterProgress)
        private val btnStudy: MaterialButton = itemView.findViewById(R.id.btnStudy)
        private val btnQuiz: MaterialButton = itemView.findViewById(R.id.btnStartQuiz)

        fun bind(chapter: Chapter) {
            titleTextView.text = chapter.title
            statusTextView.text = if (chapter.isCompleted) "COMPLETED" else "IN PROGRESS"
            progressIndicator.progress = if (chapter.isCompleted) 100 else 30
            
            // Apply green tint to the study button too if it's currently pink/blue
            btnStudy.setOnClickListener { onStudyClick(chapter) }
            btnQuiz.setOnClickListener { onQuizClick(chapter) }
        }
    }

    class ChapterDiffCallback : DiffUtil.ItemCallback<Chapter>() {
        override fun areItemsTheSame(oldItem: Chapter, newItem: Chapter): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Chapter, newItem: Chapter): Boolean = oldItem == newItem
    }
}
