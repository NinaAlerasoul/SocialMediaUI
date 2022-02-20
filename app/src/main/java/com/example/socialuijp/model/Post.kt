package com.example.socialuijp.model

import androidx.compose.runtime.MutableState

data class Post(
    val user: User,
    var image: String,
    var location: String,
    var caption: String,
    var like: Boolean=false,
)