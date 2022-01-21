package com.pub.feedbackapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_td")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val surname: String,
    val email: String,
    val age: Int,
    var location: String,
    val gender: String,
    val profilePicture: String,
    val password: String
)