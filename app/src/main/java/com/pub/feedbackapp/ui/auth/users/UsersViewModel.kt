package com.pub.feedbackapp.ui.auth.users

import androidx.lifecycle.*
import com.pub.feedbackapp.models.Quote
import com.pub.feedbackapp.models.User
import com.pub.feedbackapp.repositories.AuthRepository
import com.pub.feedbackapp.utils.SingleLiveEvent
import com.pub.feedbackapp.utils.isNull
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UsersViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    val goBackEvent = SingleLiveEvent<Nothing>()

    val user: LiveData<List<User>> = authRepository.getUsers().asLiveData()

    //region Intents



    //endregion
}