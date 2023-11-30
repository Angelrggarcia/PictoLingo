package com.example.pictolingo.objects

import androidx.compose.ui.graphics.Color

import com.example.pictolingo.screens.games.NumberGame

import androidx.navigation.NavHostController

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

    val ruta: String,
)

fun getLevels(): List<Level> {
    return listOf(
        Level("Fácil", 51, very_happy_face, azul_verdoso, "NumGame"),
        Level("Medio", 42, happy_face, verde, "PuzGame"),
        Level("Difícil", 35, neutral_face, rosa, "Categories"),
        Level("Muy difícil", 18, sad_face, morado, "Categories"),
    )
}
