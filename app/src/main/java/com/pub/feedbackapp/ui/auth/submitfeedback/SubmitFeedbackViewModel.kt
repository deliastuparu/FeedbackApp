package com.pub.feedbackapp.ui.auth.submitfeedback

import androidx.lifecycle.ViewModel
import com.pub.feedbackapp.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SubmitFeedbackViewModel @Inject constructor() : ViewModel() {
    val goBackEvent = SingleLiveEvent<Nothing>()

    //region Intents

    fun goBack() {
        goBackEvent.call()
    }

    //endregion
}