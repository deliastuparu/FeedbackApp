package com.pub.feedbackapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pub.feedbackapp.utils.isNull

@Entity(tableName = "feedback_td")
data class Feedback(
    @PrimaryKey
    val id: Int,
    val message: String,
    val timeStamp: String,
    val senderId: Int? = null,
) {
    val isAnonymous: Boolean
        get() = senderId.isNull
}