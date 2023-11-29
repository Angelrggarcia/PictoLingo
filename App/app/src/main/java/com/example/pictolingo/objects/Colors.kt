package com.example.pictolingo.objects

import androidx.compose.ui.graphics.Color
import com.example.pictolingo.ui.theme.amarillo
import com.example.pictolingo.ui.theme.azul
import com.example.pictolingo.ui.theme.azul_verdoso
import com.example.pictolingo.ui.theme.morado
import com.example.pictolingo.ui.theme.rosa
import com.example.pictolingo.ui.theme.rosa_fuerte
import com.example.pictolingo.ui.theme.verde

fun getColorList(): List<Color> {
    return listOf(
        amarillo,
        morado,
        rosa_fuerte,
        Color(0xFFBA1A1A),
        azul,
        rosa,
        verde,
        azul_verdoso,
        )
}