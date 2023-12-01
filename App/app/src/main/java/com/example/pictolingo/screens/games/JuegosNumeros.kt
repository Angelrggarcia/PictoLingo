package com.example.pictolingo.screens.games
import android.os.Looper
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pictolingo.components.TopBar
import com.example.pictolingo.ui.theme.azul
import com.example.pictolingo.ui.theme.blaco
import com.example.pictolingo.ui.theme.hueso
import com.example.pictolingo.ui.theme.otro_blaco
import com.example.pictolingo.ui.theme.rosa_fuerte
import com.example.pictolingo.ui.theme.verde
import kotlin.random.Random


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JuegosNumeros(navController: NavHostController){
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopBar(navController, scrollBehavior, "Levels")
        },
    ) {innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            NumberGame()
        }
    }
}


@Composable
fun NumberGame() {
    var number1 by remember { mutableStateOf(generateRandomNumber()) }
    var number2 by remember { mutableStateOf(generateRandomNumber()) }
    var color1 by remember { mutableStateOf(azul) }
    var color2 by remember { mutableStateOf(azul) }
    var message by remember { mutableStateOf("") }

    fun numberChecked(selected: Int) {
        if(selected == 2) {
            color2 = if (number2 >= number1) {
                verde
            } else {
                rosa_fuerte
            }
        } else {
            color1 = if (number2 <= number1) {
                verde
            } else {
                rosa_fuerte
            }
        }

        message = compareNumbers(number1, number2)

        android.os.Handler(Looper.getMainLooper()).postDelayed({
            number1 = generateRandomNumber()
            number2 = generateRandomNumber()
            color1 = azul
            color2 = azul
        }, 2000)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(
                color = otro_blaco,
                shape = RoundedCornerShape(40.dp))
            .border(width = 4.dp, color = hueso, shape = RoundedCornerShape(40.dp)),

        contentAlignment = Alignment.Center,
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Selecciona el número más grande",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Button(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(10.dp),
                    colors = buttonColors(color1, blaco, color1, blaco),
                    onClick = {
                        numberChecked(1)
                    }) {
                    Text((number1.toString()), fontSize = 80.sp)
                }

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    colors = buttonColors(color2, blaco, color2, blaco),
                    onClick = {
                        numberChecked(2)
                    }) {
                    Text((number2.toString()), fontSize = 80.sp)
                }
            }


            Spacer(modifier = Modifier.height(16.dp))

            Text(message, color = Color.Gray)
        }
    }
}

fun generateRandomNumber(): Int {
    return Random.nextInt(1, 30)
}

fun compareNumbers(number1: Int, number2: Int): String {
    return when {
        number1 > number2 -> "¡Número 1 es más grande!"
        number2 > number1 -> "¡Número 2 es más grande!"
        else -> "¡Ambos números son iguales!"
    }
}

