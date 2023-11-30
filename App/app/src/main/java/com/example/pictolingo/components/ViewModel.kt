package com.example.pictolingo.components

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pictolingo.objects.Pictogram

class MiViewModel : ViewModel() {
    var lista: MutableList<Pictogram> = mutableListOf()
}