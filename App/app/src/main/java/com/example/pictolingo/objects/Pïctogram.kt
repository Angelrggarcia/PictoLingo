package com.example.pictolingo.objects

import com.example.pictolingo.R

data class Pictogram(
    val name: String,
    val picture: Int,
)

data class PictogramPack(
    val name: String,
    val anagrams: List<Pictogram>,
    val color: String,
    val picture: Int,
    // More valueeeees... maybe?
)

fun getPictogramPacks(): List<PictogramPack> {
    return listOf(
        PictogramPack(
            "animales",
            listOf(
                Pictogram("Bulbasaur", R.drawable.abeja),
                Pictogram("Charmander", R.drawable.abeja),
                Pictogram("Weedle", R.drawable.abeja),
                Pictogram("Mew", R.drawable.abeja),
                Pictogram("Pikachu", R.drawable.abeja),
                Pictogram("Pichu", R.drawable.abeja),
                Pictogram("Mewtwo", R.drawable.abeja),
                Pictogram("Rufflet", R.drawable.abeja),
                Pictogram("Braviary", R.drawable.abeja),
                Pictogram("Eevee", R.drawable.abeja)
            ), "Azul", R.drawable.abeja)
    )
}