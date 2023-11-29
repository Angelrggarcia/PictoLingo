package com.example.pictolingo.components

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.Locale

fun textToSpeech(text: String, context: Context) {
    lateinit var tts : TextToSpeech
    tts = TextToSpeech(context) {
        if (it == TextToSpeech.SUCCESS) {
            tts.language = Locale("es", "MX")
            tts.setSpeechRate(1.0f)
            tts.speak(text, TextToSpeech.QUEUE_ADD, null)
        }
    }
}