package com.example.pictolingo.objects

import com.example.pictolingo.R

data class User(
    val name: String,
    val picture: Int,
)


fun addUser(name: String) {
    userList.add(User(name, R.drawable.user))
}

private val userList = mutableListOf(
    User("Juanito", R.drawable.user),
    User("Chani", R.drawable.user),
    User("Carlos", R.drawable.user),
)

fun getUsers(): List<User> {
    return userList
}