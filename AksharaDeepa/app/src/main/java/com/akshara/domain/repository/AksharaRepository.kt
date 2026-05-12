package com.akshara.domain.repository

import android.content.Context
import com.akshara.data.dao.AksharaDao
import com.akshara.data.model.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import java.util.Calendar

class AksharaRepository(private val dao: AksharaDao) {

    fun getAllSubjects(): Flow<List<Subject>> = dao.getAllSubjects()
    fun getChaptersForSubject(subjectId: Int): Flow<List<Chapter>> = dao.getChaptersForSubject(subjectId)
    suspend fun getChapterById(chapterId: Int): Chapter? = dao.getChapterById(chapterId)
    
    suspend fun updateChapterCompletion(chapter: Chapter, isCompleted: Boolean) {
        dao.updateChapter(chapter.copy(isCompleted = isCompleted))
    }

    suspend fun getQuestionsForChapter(chapterId: Int): List<Question> = dao.getQuestionsForChapter(chapterId)

    suspend fun submitQuizResult(chapterId: Int, score: Int, totalQuestions: Int) {
        dao.insertQuizResult(QuizResult(chapterId = chapterId, score = score, totalQuestions = totalQuestions))
        if (totalQuestions > 0 && score.toFloat() / totalQuestions >= 0.8f) {
            dao.getChapterById(chapterId)?.let { dao.updateChapter(it.copy(isCompleted = true)) }
        }
    }

    fun getUserProgress(): Flow<UserProgress?> = dao.getUserProgress()
    
    fun getWeakChapters(): Flow<List<Chapter>> = dao.getWeakChapters()
    
    fun getSubjectStrength(subId: Int): Flow<Float?> = dao.getSubjectAverageScore(subId)

    suspend fun updateDailyStreak() {
        val progress = dao.getUserProgress().firstOrNull() ?: UserProgress(id = 1)
        val now = Calendar.getInstance()
        val last = Calendar.getInstance().apply { timeInMillis = progress.lastActiveDate }
        val isToday = now.get(Calendar.DAY_OF_YEAR) == last.get(Calendar.DAY_OF_YEAR) && now.get(Calendar.YEAR) == last.get(Calendar.YEAR)
        if (isToday && progress.dailyGoalStreak > 0) return
        
        val yesterday = Calendar.getInstance().apply { add(Calendar.DAY_OF_YEAR, -1) }
        val isYesterday = yesterday.get(Calendar.DAY_OF_YEAR) == last.get(Calendar.DAY_OF_YEAR) && yesterday.get(Calendar.YEAR) == last.get(Calendar.YEAR)
        val newStreak = if (isYesterday) progress.dailyGoalStreak + 1 else 1

        dao.updateUserProgress(progress.copy(dailyGoalStreak = newStreak, lastActiveDate = System.currentTimeMillis()))
    }

    suspend fun ensureDataPopulated(context: Context) {
        // 1. Ensure Subjects exist
        if (dao.getSubjectCount() == 0) {
            dao.insertSubjects(listOf(
                Subject(1, "Science", "ic_science", "#38A169"),
                Subject(2, "Mathematics", "ic_math", "#3182CE"),
                Subject(3, "Social Science", "ic_social", "#E53E3E")
            ))
        }

        // 2. Ensure Chapters exist (Check if any chapters are missing)
        // We check a few sample IDs to see if chapters need to be populated
        if (dao.getChapterById(1) == null || dao.getChapterById(11) == null || dao.getChapterById(21) == null) {
            val chapters = mutableListOf<Chapter>()
            // Science 1-10
            val sciTitles = listOf("Chemical Reactions", "Acids, Bases and Salts", "Metals and Non-metals", "Carbon and its Compounds", "Life Processes", "Control and Coordination", "How do Organisms Reproduce?", "Heredity and Evolution", "Light - Reflection and Refraction", "Human Eye and Colourful World")
            sciTitles.forEachIndexed { i, t -> chapters.add(Chapter(i + 1, 1, t, false, 10)) }
            
            // Math 11-20
            val mathTitles = listOf("Real Numbers", "Polynomials", "Pair of Linear Equations", "Quadratic Equations", "Arithmetic Progressions", "Triangles", "Coordinate Geometry", "Introduction to Trigonometry", "Circles", "Statistics")
            mathTitles.forEachIndexed { i, t -> chapters.add(Chapter(i + 11, 2, t, false, 10)) }
            
            // Social 21-30
            val socTitles = listOf("Rise of Nationalism in Europe", "Nationalism in India", "Making of a Global World", "Age of Industrialization", "Resources and Development", "Forest and Wildlife Resources", "Water Resources", "Agriculture", "Minerals and Energy Resources", "Manufacturing Industries")
            socTitles.forEachIndexed { i, t -> chapters.add(Chapter(i + 21, 3, t, false, 10)) }
            
            dao.insertChapters(chapters)
        }

        // 3. Always refresh questions to ensure they match the Repository exactly
        // This handles updates to question text or fixes.
        val questions = QuizRepository.getAllQuestions()
        if (questions.isNotEmpty()) {
            dao.insertQuestions(questions)
        }
    }
}
