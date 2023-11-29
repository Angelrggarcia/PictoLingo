package com.example.pictolingo.objects

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import coil.compose.AsyncImagePainter
import com.example.pictolingo.R

data class Pictogram(
    val name: String,
    val picture: AsyncImagePainter,
    val color: Color,
)
data class PictogramPack(
    val name: String,
    val anagrams: List<Pictogram>,
    val color: Color,
    val picture: AsyncImagePainter,
    // More valueeeees... maybe?
)



@Composable
fun getPictogramPacks(): List<PictogramPack> {
    return listOf(
        PictogramPack(
            "animales",
            listOf(
                Pictogram("Abeja", intToAsync(R.drawable.abeja),Color(0xFFB2C8E8)),
                Pictogram("Burro", intToAsync(R.drawable.burro),Color(0xFFB2C8E8)),
                Pictogram("Conejo", intToAsync(R.drawable.conejo),Color(0xFFB2C8E8)),
                Pictogram("Pingüino",intToAsync(R.drawable.pinguino),Color(0xFFB2C8E8)),
                Pictogram("Vaca", intToAsync(R.drawable.vaca),Color(0xFFB2C8E8)),
                Pictogram("Gato", intToAsync(R.drawable.gato),Color(0xFFB2C8E8)),
                Pictogram("Raton", intToAsync(R.drawable.raton),Color(0xFFB2C8E8)),
                Pictogram("Pato", intToAsync(R.drawable.pato),Color(0xFFB2C8E8)),
                Pictogram("Zarigüeya", intToAsync(R.drawable.zarigueya),Color(0xFFB2C8E8)),
                Pictogram("Zorra", intToAsync(R.drawable.zorra),Color(0xFFB2C8E8))
            ), Color(0xFFB2C8E8), intToAsync(R.drawable.animales))
    )
}

fun setPictogramPack(){

}

fun setPictogram(){

}

fun delete(){

}