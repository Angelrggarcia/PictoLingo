package com.example.pictolingo.objects

data class User(
    val name: String,
    val url: String,
)

fun getUsers(): List<User> {
    return listOf(
        User("Juanito", "https://img.pokemondb.net/artwork/large/bulbasaur.jpg"),
        User("Chani", "https://img.pokemondb.net/artwork/large/charmander.jpg"),
        User("Carlos", "https://img.pokemondb.net/artwork/large/weedle.jpg"),
    )
}