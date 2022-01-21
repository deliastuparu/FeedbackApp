package com.pub.feedbackapp.repositories

import com.pub.feedbackapp.models.Quote
import com.pub.feedbackapp.models.User
import com.pub.feedbackapp.network.MainApi
import com.pub.feedbackapp.persistance.dao.UserDao
import com.pub.feedbackapp.utils.onSuccess
import com.pub.feedbackapp.utils.safeCall
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ActivityScoped
class AuthRepositoryImpl @Inject constructor(
    private val mainApi: MainApi,
    private val userDao: UserDao
) : AuthRepository {
    override fun getQuoteOfDay(): Flow<Quote> = flow {
        safeCall(IO) {
            mainApi.getQuotes(3)
        }.onSuccess {
            val quote = it.quotes.first()
            emit(quote)
        }
    }

    override suspend fun getUserBy(email: String, password: String) : User? {
        var user: User? = null
        withContext(IO) {
            user = userDao.getUserBy(email, password)
        }
        return user
    }

    override suspend fun register(user: User) {
        withContext(IO) {
            userDao.insert(user)
        }
    }

    override fun getUsers(): Flow<List<User>> = userDao.getUsers()

}