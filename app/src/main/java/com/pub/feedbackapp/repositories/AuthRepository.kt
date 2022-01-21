package com.pub.feedbackapp.repositories

import com.pub.feedbackapp.models.Quote
import com.pub.feedbackapp.models.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun getQuoteOfDay(): Flow<Quote>

    suspend fun getUserBy(email: String, password: String): User?

    suspend fun register(user: User)

    fun getUsers(): Flow<List<User>>
}