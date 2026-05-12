package com.akshara.presentation.ui

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.akshara.R
import com.akshara.data.model.Subject
import com.google.android.material.card.MaterialCardView
import com.google.android.material.progressindicator.LinearProgressIndicator

class SubjectAdapter(private val onSubjectClick: (Subject) -> Unit) : ListAdapter<Subject, SubjectAdapter.SubjectViewHolder>(SubjectDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_subject_tile, parent, false)
        return SubjectViewHolder(view, onSubjectClick)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class SubjectViewHolder(itemView: View, private val onSubjectClick: (Subject) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.subjectName)
        private val iconImageView: ImageView = itemView.findViewById(R.id.subjectIcon)
        private val iconContainer: MaterialCardView = itemView.findViewById(R.id.iconContainer)
        private val progressIndicator: LinearProgressIndicator = itemView.findViewById(R.id.subjectProgress)
        private val chapterCountTextView: TextView = itemView.findViewById(R.id.chapterCount)

        fun bind(subject: Subject) {
            nameTextView.text = subject.name
            
            val color = try {
                Color.parseColor(subject.colorHex)
            } catch (e: Exception) {
                Color.parseColor("#3B82F6")
            }
            
            // Set icon background and tint based on subject color
            iconContainer.setCardBackgroundColor(color)
            iconContainer.alpha = 0.15f
            
            // We need another way to set the actual tint because alpha affects the container
            // Resetting alpha for clarity and using a separate color for icon
            val lightColor = Color.argb(40, Color.red(color), Color.green(color), Color.blue(color))
            iconContainer.setCardBackgroundColor(lightColor)
            iconContainer.alpha = 1.0f
            
            iconImageView.setColorFilter(color)
            progressIndicator.setIndicatorColor(color)
            progressIndicator.trackColor = Color.argb(30, Color.red(color), Color.green(color), Color.blue(color))

            // Dynamic icons (Assuming you have these or using fallbacks)
            val iconRes = when (subject.id) {
                1 -> android.R.drawable.ic_menu_edit // Math
                2 -> android.R.drawable.ic_menu_view // Science
                3 -> android.R.drawable.ic_menu_myplaces // Social
                else -> android.R.drawable.ic_menu_compass
            }
            iconImageView.setImageResource(iconRes)
            
            chapterCountTextView.text = "Click to view chapters"

            itemView.setOnClickListener { onSubjectClick(subject) }
        }
    }

    class SubjectDiffCallback : DiffUtil.ItemCallback<Subject>() {
        override fun areItemsTheSame(oldItem: Subject, newItem: Subject): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Subject, newItem: Subject): Boolean = oldItem == newItem
    }
}
