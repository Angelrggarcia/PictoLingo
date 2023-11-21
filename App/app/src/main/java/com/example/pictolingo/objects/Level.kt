package com.example.pictolingo.objects

import androidx.compose.ui.graphics.Color
import com.example.pictolingo.ui.theme.azul_verdoso
import com.example.pictolingo.ui.theme.happy_face
import com.example.pictolingo.ui.theme.morado
import com.example.pictolingo.ui.theme.very_happy_face
import com.example.pictolingo.ui.theme.neutral_face
import com.example.pictolingo.ui.theme.rosa
import com.example.pictolingo.ui.theme.sad_face
import com.example.pictolingo.ui.theme.verde


data class Level(
    val name: String,
    val count: Number,
    val emoji: Int,
    val color: Color,
)

fun getLevels(): List<Level> {
    return listOf(
        Level("Fácil", 51, very_happy_face, azul_verdoso),
        Level("Medio", 42, happy_face, verde),
        Level("Difícil", 35, neutral_face, rosa),
        Level("Muy difícil", 18, sad_face, morado),
    )
}