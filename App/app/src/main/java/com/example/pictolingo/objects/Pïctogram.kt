package com.example.pictolingo.objects

import androidx.compose.runtime.Composable
import coil.compose.AsyncImagePainter
import com.example.pictolingo.R

data class Pictogram(
    val name: String,
    val picture: AsyncImagePainter,
)

data class PictogramPack(
    val name: String,
    val anagrams: List<Pictogram>,
    val color: String,
    val picture: AsyncImagePainter,
    // More valueeeees... maybe?
)
@Composable
fun getPictogramPacks(): List<PictogramPack> {
    return listOf(
        PictogramPack(
            "animales",
            listOf(
                Pictogram("Abeja", intToAsync(R.drawable.abeja)),
                Pictogram("Burro", intToAsync(R.drawable.burro)),
                Pictogram("Conejo", intToAsync(R.drawable.conejo)),
                Pictogram("Pingüino",intToAsync(R.drawable.pinguino)),
                Pictogram("Vaca", intToAsync(R.drawable.vaca)),
                Pictogram("Gato", intToAsync(R.drawable.gato)),
                Pictogram("Raton", intToAsync(R.drawable.raton)),
                Pictogram("Pato", intToAsync(R.drawable.pato)),
                Pictogram("Zarigüeya", intToAsync(R.drawable.zarigueya)),
                Pictogram("Zorra", intToAsync(R.drawable.zorra))
            ), "Azul", intToAsync(R.drawable.animales))
    )
}