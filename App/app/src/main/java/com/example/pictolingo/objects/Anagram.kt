package com.example.pictolingo.objects

data class Anagram(
    val name: String,
    val urlPicture: String,
)

data class AnagramPack(
    val name: String,
    val anagrams: List<Anagram>,
    val color: String,
    // More valueeeees... maybe?
)

fun getAnagramPacks(): List<AnagramPack> {
    return listOf(
        AnagramPack(
            "Pokemon",
            listOf(
                    Anagram("Bulbasaur", "https://img.pokemondb.net/artwork/large/bulbasaur.jpg"),
                    Anagram("Charmander", "https://img.pokemondb.net/artwork/large/charmander.jpg"),
                    Anagram("Weedle", "https://img.pokemondb.net/artwork/large/weedle.jpg"),
                    Anagram("Mew", "https://img.pokemondb.net/artwork/large/mew.jpg"),
                    Anagram("Pikachu", "https://img.pokemondb.net/artwork/large/pikachu.jpg"),
                    Anagram("Pichu", "https://img.pokemondb.net/artwork/large/pichu.jpg"),
                    Anagram("Mewtwo", "https://img.pokemondb.net/artwork/large/mewtwo.jpg"),
                    Anagram("Rufflet", "https://img.pokemondb.net/artwork/large/rufflet.jpg"),
                    Anagram("Braviary", "https://img.pokemondb.net/artwork/large/braviary.jpg"),
                    Anagram("Eevee", "https://img.pokemondb.net/artwork/large/eevee.jpg")
            ), "Azul")
    )
}