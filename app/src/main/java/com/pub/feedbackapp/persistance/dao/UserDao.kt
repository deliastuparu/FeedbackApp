package com.pub.feedbackapp.persistance.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pub.feedbackapp.models.User
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {
    @Query("SELECT * from user_td WHERE email = :email AND password = :password LIMIT 1")
    suspend fun getUserBy(email: String, password: String): User

    @Query("SELECT * from user_td WHERE id = :id LIMIT 1")
    fun getUserBy(id: Int): Flow<User>

    @Query("SELECT * from user_td")
    fun getUsers(): Flow<List<User>>

    @Insert
    fun insert(user: User)
}
