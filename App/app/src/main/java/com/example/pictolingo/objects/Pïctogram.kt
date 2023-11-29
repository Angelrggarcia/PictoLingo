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
)

@Composable
fun getPictogramPacks(): List<PictogramPack> {
    return listOf(
        PictogramPack(
            "Animales",
            listOf(
                Pictogram("Ardilla", intToAsync(R.drawable.ardilla), Color(0xFFB2C8E8)),
                Pictogram("Burro", intToAsync(R.drawable.burro), Color(0xFFB2C8E8)),
                Pictogram("Canguro", intToAsync(R.drawable.canguro), Color(0xFFB2C8E8)),
                Pictogram("Cerdo", intToAsync(R.drawable.cerdo), Color(0xFFB2C8E8)),
                Pictogram("Cucaracha", intToAsync(R.drawable.cucaracha), Color(0xFFB2C8E8)),
                Pictogram("Delfín", intToAsync(R.drawable.delfin), Color(0xFFB2C8E8)),
                Pictogram("Gato", intToAsync(R.drawable.gato), Color(0xFFB2C8E8)),
                Pictogram("Hipopótamo", intToAsync(R.drawable.hipopotamo), Color(0xFFB2C8E8)),
                Pictogram("Ladrar", intToAsync(R.drawable.ladrar), Color(0xFFB2C8E8)),
                Pictogram("Mapache", intToAsync(R.drawable.mapache), Color(0xFFB2C8E8)),
                Pictogram("Pato", intToAsync(R.drawable.patito), Color(0xFFB2C8E8)),
                Pictogram("Pingüino", intToAsync(R.drawable.pinguino), Color(0xFFB2C8E8)),
                Pictogram("Ratón", intToAsync(R.drawable.raton), Color(0xFFB2C8E8)),
                Pictogram("Vaca", intToAsync(R.drawable.vaca), Color(0xFFB2C8E8)),
                Pictogram("Zarigüeya", intToAsync(R.drawable.tlacuache), Color(0xFFB2C8E8)),
                Pictogram("Zorra", intToAsync(R.drawable.zorra), Color(0xFFB2C8E8))
            ), Color(0xFFB2C8E8), intToAsync(R.drawable.animales))
    )
}