package com.example.pictolingo.screens.games.puzzle

import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavHostController
import com.example.pictolingo.components.TopBar
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HiLowsGams(navController: NavHostController){
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
            HiLowGame()
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HiLowGame() {
    var targetNumber by remember { mutableStateOf((1..20).random()) }
    var userInput by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("¡Adivina el número!") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message,
            style = MaterialTheme.typography,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        TextField(
            value = userInput,
            onValueChange = {
                userInput = it
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    if (userInput.isNotBlank()) {
                        checkGuess(userInput.toInt(), targetNumber) { newMessage ->
                            message = newMessage
                        }
                    }
                }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (userInput.isNotBlank()) {
                    checkGuess(userInput.toInt(), targetNumber) { newMessage ->
                        message = newMessage
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Adivinar")
        }
    }
}

fun Text(text: String, style: Typography, modifier: Modifier) {

}

fun checkGuess(guess: Int, target: Int, onMessageUpdate: (String) -> Unit) {
    when {
        guess < target -> {
            onMessageUpdate("Demasiado bajo. Intenta de nuevo.")
        }
        guess > target -> {
            onMessageUpdate("Demasiado alto. Intenta de nuevo.")
        }
        else -> {
            onMessageUpdate("¡Felicidades! ¡Adivinaste el número!")
        }
    }
}