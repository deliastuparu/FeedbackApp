package com.pub.feedbackapp.repositories

import com.pub.feedbackapp.models.User
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getUserBy(id: Int): Flow<User>
}