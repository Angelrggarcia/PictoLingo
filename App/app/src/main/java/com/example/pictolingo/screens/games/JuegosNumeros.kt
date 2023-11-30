package com.example.pictolingo.screens.games
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pictolingo.components.TopBar
import com.example.pictolingo.screens.users.Levels
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
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
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

        Button(onClick = {
            message = compareNumbers(number1, number2)
            number1 = generateRandomNumber()
            number2 = generateRandomNumber()
        }) {
            Text("Número 1: $number1")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            message = compareNumbers(number1, number2)
            number1 = generateRandomNumber()
            number2 = generateRandomNumber()
        }) {
            Text("Número 2: $number2")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(message, color = Color.Gray)
    }
}

fun generateRandomNumber(): Int {
    return Random.nextInt(1, 100)
}

fun compareNumbers(number1: Int, number2: Int): String {
    return when {
        number1 > number2 -> "¡Número 1 es más grande!"
        number2 > number1 -> "¡Número 2 es más grande!"
        else -> "¡Ambos números son iguales!"
    }
}

