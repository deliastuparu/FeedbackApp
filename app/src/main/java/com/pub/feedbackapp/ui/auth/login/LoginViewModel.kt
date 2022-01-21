package com.pub.feedbackapp.ui.auth.login

import android.util.Log
import androidx.lifecycle.*
import com.pub.feedbackapp.models.Quote
import com.pub.feedbackapp.repositories.AuthRepository
import com.pub.feedbackapp.utils.SingleLiveEvent
import com.pub.feedbackapp.utils.isNotNull
import com.pub.feedbackapp.utils.isNull
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    val quote: LiveData<Quote> = authRepository.getQuoteOfDay().asLiveData()

    val showRegisterEvent = SingleLiveEvent<Nothing>()
    val showUsersEvent = SingleLiveEvent<Nothing>()
    val succesLoginEvent = SingleLiveEvent<Int>()

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    //region Intents

    fun showRegister() {
        showRegisterEvent.call()
    }

    fun login() {
        viewModelScope.launch {
            if (email.value.isNull) {

            }
            if (password.value.isNull) {

            }

            val user = authRepository.getUserBy(email.value!!, password.value!!)
            if (user.isNull) {
                return@launch
            }

            succesLoginEvent.postValue(user?.id)
        }
    }

    fun showUsers() {
        showUsersEvent.call()
    }

    //endregion
}