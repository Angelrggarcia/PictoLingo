package com.example.pictolingo.screens.games.puzzle

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.ui.unit.Dp

data class PiezaRompecabezas(val bitmap: Bitmap, val id: Int)

fun cortarImagenEnPiezas(context: Context, drawableId: Int, size: Dp): List<PiezaRompecabezas> {
    val imagenOriginal = BitmapFactory.decodeResource(context.resources, drawableId)
    val scaledBitmap = Bitmap.createScaledBitmap(imagenOriginal, size.value.toInt() * 3, size.value.toInt() * 3, true)
    val piezas = mutableListOf<PiezaRompecabezas>()
    val anchoPieza = scaledBitmap.width / 3
    val altoPieza = scaledBitmap.height / 3

    var id = 0
    for (y in 0 until 3) {
        for (x in 0 until 3) {
            val xCoord = x * anchoPieza
            val yCoord = y * altoPieza
            piezas.add(PiezaRompecabezas(Bitmap.createBitmap(scaledBitmap, xCoord, yCoord, anchoPieza, altoPieza), id++))
        }
    }
    return piezas
}