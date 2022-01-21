package com.pub.feedbackapp.ui.auth.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pub.feedbackapp.models.User
import com.pub.feedbackapp.repositories.AuthRepository
import com.pub.feedbackapp.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    val registerEvent = SingleLiveEvent<Nothing>()

    val surname = MutableLiveData<String>()
    val name = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    //region Intents

    fun register() {
        val user = User(
            surname = surname.value ?: "NumeFam1",
            name = name.value ?: "Name1",
            email = email.value ?: "email",
            age = 5,
            location = "Bucuresti",
            gender = "Female",
            profilePicture = "",
            password = password.value ?: ""
        )

        registerEvent.call()
    }

    //endregion
}