package com.example.pictolingo.objects

import com.example.pictolingo.R

data class User(
    val name: String,
    val picture: Int,
)

fun getUsers(): List<User> {
    return listOf(
        User("Juanito", R.drawable.user),
        User("Chani", R.drawable.user),
        User("Carlos", R.drawable.user),
    )
}