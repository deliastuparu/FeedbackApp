package com.pub.feedbackapp.persistance

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pub.feedbackapp.models.Feedback
import com.pub.feedbackapp.models.User
import com.pub.feedbackapp.persistance.dao.FeedbackDao
import com.pub.feedbackapp.persistance.dao.UserDao

@Database(
    entities = [
        User::class,
        Feedback::class,
    ],
    version = 33
)
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao: UserDao
    abstract val feedbackDao: FeedbackDao

    companion object {
        const val DATABASE_NAME = "application.db"
    }
}