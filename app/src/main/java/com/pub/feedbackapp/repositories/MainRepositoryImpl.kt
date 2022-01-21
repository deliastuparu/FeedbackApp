package com.pub.feedbackapp.repositories

import com.pub.feedbackapp.models.User
import com.pub.feedbackapp.network.MainApi
import com.pub.feedbackapp.persistance.dao.UserDao
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ActivityScoped
class MainRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : MainRepository {
    override fun getUserBy(id: Int): Flow<User> = userDao.getUserBy(id)
}