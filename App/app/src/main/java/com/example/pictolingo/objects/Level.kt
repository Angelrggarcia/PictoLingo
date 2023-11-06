package com.example.pictolingo.objects

import androidx.compose.ui.graphics.Color
import com.example.pictolingo.ui.theme.happy_face
import com.example.pictolingo.ui.theme.very_happy_face
import com.example.pictolingo.ui.theme.neutral_face
import com.example.pictolingo.ui.theme.sad_face


data class Level(
    val name: String,
    val count: Number,
    val emoji: Int,
    val color: Color,
)

fun getLevels(): List<Level> {
    return listOf(
        Level("Fácil", 51, very_happy_face, Color(0xFF930000)),
        Level("Medio", 42, happy_face, Color(0xFF930000)),
        Level("Difícil", 35, neutral_face, Color(0xFF930000)),
        Level("Muy difícil", 18, sad_face, Color(0xFF930000)),
    )
}