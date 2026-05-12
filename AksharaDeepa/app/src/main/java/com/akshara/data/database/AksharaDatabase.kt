package com.akshara.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.akshara.data.dao.AksharaDao
import com.akshara.data.model.*

@Database(
    entities = [
        Subject::class,
        Chapter::class,
        Question::class,
        QuizResult::class,
        UserProgress::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AksharaDatabase : RoomDatabase() {

    abstract fun aksharaDao(): AksharaDao

    companion object {
        @Volatile
        private var INSTANCE: AksharaDatabase? = null

        fun getDatabase(context: Context): AksharaDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AksharaDatabase::class.java,
                    "akshara_deepa_database"
                )
                .fallbackToDestructiveMigration()
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
