package com.example.pictolingo.components

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*

@Composable
fun TextToSpeechScreen() {
    val context = LocalContext.current
    val textToSpeech by remember { mutableStateOf<TextToSpeech?>(null) }
    val text = remember { mutableStateOf("¡Hola! Presiona el botón para escuchar.") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = text.value,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
        Button(onClick = { textToSpeech?.let { speak(text.value, it) } }) {
            Text("Hablar")
        }
    }
}

fun speak(text: String, textToSpeech: TextToSpeech) {
    val utteranceId = "utteranceId"
    textToSpeech.language = Locale.getDefault()
    textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId)
}

@Preview
@Composable
fun PreviewTextToSpeechScreen() {
    TextToSpeechScreen()
}