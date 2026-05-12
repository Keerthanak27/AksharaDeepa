package com.akshara.worker

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.akshara.data.database.AksharaDatabase
import kotlinx.coroutines.flow.firstOrNull
import java.util.Calendar

class DailyGoalWorker(
    private val context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    // 🌟 Variety keeps engagement high
    private val motivationalMessages = listOf(
        "A 5-minute quiz today keeps the exam stress away! 🚀",
        "Consistency is your superpower. Review your syllabus now! 📚",
        "Your future self will thank you for studying today. 🌟",
        "Don't break your streak! The Akshara-Deepa quiz is waiting.",
        "Small steps every day equal massive SSLC scores. Let's practice!"
    )

    override suspend fun doWork(): Result {
        val database = AksharaDatabase.getDatabase(context)
        val progress = database.aksharaDao().getUserProgress().firstOrNull()

        // Default to not studied today
        var studiedToday = false

        if (progress != null) {
            val lastActiveDate = progress.lastActiveDate
            
            val calendarNow = Calendar.getInstance()
            val calendarLast = Calendar.getInstance().apply { timeInMillis = lastActiveDate }
            
            studiedToday = calendarNow.get(Calendar.YEAR) == calendarLast.get(Calendar.YEAR) &&
                           calendarNow.get(Calendar.DAY_OF_YEAR) == calendarLast.get(Calendar.DAY_OF_YEAR)
        }

        // Only send the notification if they HAVEN'T touched the app today
        if (!studiedToday) {
            sendNotification()
        }
        
        return Result.success()
    }

    private fun sendNotification() {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val message = motivationalMessages.random()

        val notification = NotificationCompat.Builder(context, "akshara_reminders")
            .setSmallIcon(android.R.drawable.ic_dialog_info) 
            .setContentTitle("Akshara-Deepa Daily Quiz")
            .setContentText(message)
            .setStyle(NotificationCompat.BigTextStyle().bigText(message)) // Expands to show full text
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .build()

        // System.currentTimeMillis().toInt() allows multiple unique notifications if needed, 
        // but for a daily worker, using a static ID (like 1001) is often better to avoid spam.
        notificationManager.notify(1001, notification)
    }
}
