package com.akshara.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "subjects")
data class Subject(
    @PrimaryKey val id: Int,
    val name: String,
    val iconResName: String, // Store resource name to look up dynamically
    val colorHex: String
)

@Entity(
    tableName = "chapters",
    foreignKeys = [
        ForeignKey(
            entity = Subject::class,
            parentColumns = ["id"],
            childColumns = ["subjectId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Chapter(
    @PrimaryKey val id: Int,
    val subjectId: Int,
    val title: String,
    val isCompleted: Boolean = false,
    val weightage: Int
)

@Entity(
    tableName = "questions",
    foreignKeys = [
        ForeignKey(
            entity = Chapter::class,
            parentColumns = ["id"],
            childColumns = ["chapterId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Question(
    @PrimaryKey val id: Int,
    val chapterId: Int,
    val text: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val optionD: String,
    val correctOption: Char, // 'A', 'B', 'C', or 'D'
    val explanation: String
)

@Entity(
    tableName = "quiz_results",
    foreignKeys = [
        ForeignKey(
            entity = Chapter::class,
            parentColumns = ["id"],
            childColumns = ["chapterId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class QuizResult(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val chapterId: Int,
    val score: Int,
    val totalQuestions: Int,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "user_progress")
data class UserProgress(
    @PrimaryKey val id: Int = 1, // Only tracking one user locally
    val dailyGoalStreak: Int = 0,
    val lastActiveDate: Long = System.currentTimeMillis()
)
