package com.akshara.data.dao

import androidx.room.*
import com.akshara.data.model.*
import kotlinx.coroutines.flow.Flow

@Dao
interface AksharaDao {

    @Query("SELECT * FROM subjects")
    fun getAllSubjects(): Flow<List<Subject>>

    @Query("SELECT COUNT(*) FROM subjects")
    suspend fun getSubjectCount(): Int

    @Query("SELECT COUNT(*) FROM questions")
    suspend fun getQuestionCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubjects(subjects: List<Subject>)

    @Query("SELECT * FROM chapters WHERE subjectId = :subId")
    fun getChaptersForSubject(subId: Int): Flow<List<Chapter>>

    @Query("SELECT * FROM chapters WHERE subjectId = :subId")
    suspend fun getChaptersForSubjectOnce(subId: Int): List<Chapter>

    @Query("SELECT * FROM chapters WHERE id = :id")
    suspend fun getChapterById(id: Int): Chapter?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChapters(chapters: List<Chapter>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestions(questions: List<Question>)

    @Update
    suspend fun updateChapter(chapter: Chapter)

    @Query("SELECT * FROM questions WHERE chapterId = :chapterId")
    suspend fun getQuestionsForChapter(chapterId: Int): List<Question>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuizResult(result: QuizResult)

    @Query("SELECT COUNT(*) FROM quiz_results WHERE timestamp >= :timestamp")
    suspend fun getResultsCountSince(timestamp: Long): Int

    @Query("""
        SELECT AVG(CAST(score AS FLOAT) / totalQuestions) 
        FROM quiz_results 
        WHERE chapterId IN (SELECT id FROM chapters WHERE subjectId = :subId)
    """)
    fun getSubjectAverageScore(subId: Int): Flow<Float?>

    @Query("""
        SELECT c.* FROM chapters c
        INNER JOIN quiz_results q ON c.id = q.chapterId
        GROUP BY c.id
        HAVING AVG(CAST(q.score AS FLOAT) / q.totalQuestions) < :threshold
    """)
    fun getWeakChapters(threshold: Float = 0.4f): Flow<List<Chapter>>

    @Query("SELECT * FROM user_progress WHERE id = 1")
    fun getUserProgress(): Flow<UserProgress?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUserProgress(progress: UserProgress)
}
