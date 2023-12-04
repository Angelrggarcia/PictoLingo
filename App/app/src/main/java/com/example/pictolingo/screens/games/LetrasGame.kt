package com.example.pictolingo.screens.games

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pictolingo.components.TopBar
import com.example.pictolingo.objects.getPictogramPacks
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JuegoLetras(navController: NavHostController){
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState() )
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopBar( navController , scrollBehavior  , "levels" )
        },
    ) {innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            LetrasGame()
        }
    }
}

@Composable
fun LetrasGame() {
    // Lista de palabras posibles
    val pictogramas = getPictogramPacks()

    var pictogramaActual by remember { mutableStateOf(pictogramas.random()) }
    var palabraActual by remember { mutableStateOf(pictogramaActual.anagrams.random().name) }
    var letrasSeleccionadas by remember { mutableStateOf("") }
    var juegoCompletado by remember { mutableStateOf(false) }
    var mensaje by remember { mutableStateOf("") }

    val orientation = LocalConfiguration.current.orientation
    val columns = if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
        GridCells.Fixed(10) // Más columnas en modo horizontal
    } else {
        GridCells.Fixed(7) // Menos columnas en modo vertical
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = palabraActual)
        Text(text = letrasSeleccionadas)
        Text(text = mensaje)

        val letras = listOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'Á', 'É', 'Í', 'Ó', 'Ú', 'Ü', ' ',).filter{it in palabraActual.uppercase(Locale.ROOT) }


        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth(),
            columns = columns,
            horizontalArrangement = Arrangement.Center,
            contentPadding = PaddingValues(4.dp),

        ) {
            items(letras.size) { index ->
                Button(
                    onClick = {
                        if (!juegoCompletado && letrasSeleccionadas.length < palabraActual.length) {
                            letrasSeleccionadas += letras[index]
                        }
                    },
                    modifier = Modifier
                        .padding(2.dp),
                    ) {
                    Text(text = letras[index].toString(),
                        textAlign = TextAlign.Center)
                }
            }
        }

        Button(
            onClick = {
                if (letrasSeleccionadas.isNotEmpty()) {
                    letrasSeleccionadas = letrasSeleccionadas.dropLast(1)
                }
                mensaje = "" // Limpiar mensaje anterior
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Borrar Última Letra")
        }

        // Botón para enviar la palabra
        Button(
            onClick = {
                if (letrasSeleccionadas.equals(palabraActual, ignoreCase = true)) {
                    mensaje = "¡Bien hecho!"
                    juegoCompletado = true
                } else {
                    mensaje = "Intenta de nuevo"
                    letrasSeleccionadas = "" // Reiniciar la palabra actual
                }
            },
            modifier = Modifier.padding(16.dp),
            //enabled = letrasSeleccionadas.length == palabraActual.length // Habilitar solo si la palabra está completa
        ) {
            Text("Enviar Palabra")
        }

        // Botón para reiniciar el juego
        Button(
            onClick = {
                pictogramaActual = pictogramas.random()
                palabraActual = pictogramaActual.anagrams.random().name
                letrasSeleccionadas = ""
                juegoCompletado = false
                mensaje = ""
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Nueva Palabra")
        }
    }
}