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
                Pictogram("Abeja", R.drawable.abeja),
                Pictogram("Burro", R.drawable.burro),
                Pictogram("Conejo", R.drawable.conejo),
                Pictogram("Pingüino", R.drawable.pinguino),
                Pictogram("Vaca", R.drawable.vaca),
                Pictogram("Gato", R.drawable.gato),
                Pictogram("Raton", R.drawable.raton),
                Pictogram("Pato", R.drawable.pato),
                Pictogram("Zarigüeya", R.drawable.zarigueya),
                Pictogram("Zorra", R.drawable.zorra)
            ), "Azul", R.drawable.animales)
    )
}