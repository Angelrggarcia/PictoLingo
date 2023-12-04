package com.example.pictolingo.screens.games.puzzle


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pictolingo.R
import com.example.pictolingo.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PuzzlesScreens(navController: NavHostController){
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
                PuzzleScreen()
            }
        }
}


@Composable
fun PuzzleScreen() {
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp
    val divisor = 1
    val size = minOf(screenWidth, screenHeight) / divisor

    var drawableActual = remember { mutableStateOf(R.drawable.ardilla) }
    var piezas = remember { mutableStateOf(cortarImagenEnPiezas(context, drawableActual.value, size).shuffled()) }
    var piezasOrdenCorrecto = remember { mutableStateOf(cortarImagenEnPiezas(context, drawableActual.value, size)) }
    var showCongratulations = remember { mutableStateOf(false) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.height(16.dp))
        Text("¡Selecciona una pieza para cambiar su posicion con orea pieza!",
            fontSize = 24.sp,
            textAlign = TextAlign.Center)
        Spacer(Modifier.height(16.dp))

        // Botones para cambiar el puzzle
        Row {
            Button(onClick = {
                drawableActual.value = R.drawable.ardilla
                piezas.value = cortarImagenEnPiezas(context, drawableActual.value, size).shuffled()
                piezasOrdenCorrecto.value = cortarImagenEnPiezas(context, drawableActual.value, size)
                showCongratulations.value = false },

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent),
                modifier = Modifier.padding(4.dp)

                ) {
                Text("Ardilla",
                    color = Color.Black)
            }
            Button(onClick = {
                drawableActual.value = R.drawable.avion
                piezas.value = cortarImagenEnPiezas(context, drawableActual.value, size).shuffled()
                piezasOrdenCorrecto.value = cortarImagenEnPiezas(context, drawableActual.value, size)
                showCongratulations.value = false
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent),
                modifier = Modifier.padding(4.dp)
            ) {
                Text("Avión", color = Color.Black)
            }
            Button(onClick = {
                drawableActual.value = R.drawable.bomberos
                piezas.value = cortarImagenEnPiezas(context, drawableActual.value, size).shuffled()
                piezasOrdenCorrecto.value = cortarImagenEnPiezas(context, drawableActual.value, size)
                showCongratulations.value = false
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent),
                modifier = Modifier.padding(4.dp)

                ) {
                Text("Bomberos", color = Color.Black)
            }
        }

        GridDePiezas(piezas.value, size) { nuevasPiezas ->
            piezas.value = nuevasPiezas
            if (verificarRompecabezas(piezas.value, piezasOrdenCorrecto.value)) {
                showCongratulations.value = true
            }
        }

        // Botón para reiniciar y mezclar las piezas
        Button(onClick = {
            piezas.value = piezas.value.shuffled()
            showCongratulations.value = false
        }) {
            Text("Reiniciar")
        }

        if (showCongratulations.value) {
            AlertDialog(
                onDismissRequest = { showCongratulations.value = false },
                title = { Text(text = "FELICIDADES") },
                text = { Text(text = "Has completado el rompecabezas!") },
                confirmButton = {
                    Button(onClick = { showCongratulations.value = false }) {
                        Text("Ok")
                    }
                }
            )
        }
        Image(
            painter = painterResource(id = drawableActual.value),
            contentDescription = "Imagen completa",
            modifier = Modifier
                .fillMaxWidth(0.9f)
        )
    }
}

@Composable
fun GridDePiezas(piezas: List<PiezaRompecabezas>, size: Dp, onPiezasChanged: (List<PiezaRompecabezas>) -> Unit) {
    var piezasSeleccionadas = remember { mutableListOf<Int>() }
    val chunkedPiezas = piezas.chunked(3)

    Column {
        chunkedPiezas.forEachIndexed { rowIndex, fila ->
            Row {
                fila.forEachIndexed { colIndex, piezaRompecabezas ->
                    val index = rowIndex * 3 + colIndex
                    Image(
                        bitmap = piezaRompecabezas.bitmap.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .padding(2.dp)
                            .clickable {
                                piezasSeleccionadas.add(index)
                                if (piezasSeleccionadas.size == 2) {
                                    val nuevasPiezas = piezas.toMutableList()
                                    val temp = nuevasPiezas[piezasSeleccionadas[0]]
                                    nuevasPiezas[piezasSeleccionadas[0]] = nuevasPiezas[piezasSeleccionadas[1]]
                                    nuevasPiezas[piezasSeleccionadas[1]] = temp
                                    onPiezasChanged(nuevasPiezas)
                                    piezasSeleccionadas.clear()
                                }
                            }
                    )
                }
            }
        }
    }
}

fun verificarRompecabezas(piezasActuales: List<PiezaRompecabezas>, piezasOrdenCorrecto: List<PiezaRompecabezas>): Boolean {
    return piezasActuales.map { it.id } == piezasOrdenCorrecto.map { it.id }
}