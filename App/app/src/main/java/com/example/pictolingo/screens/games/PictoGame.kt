package com.example.pictolingo.screens.games

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pictolingo.R
import com.example.pictolingo.components.PictureCard

@Composable
fun JuegoDePictogramas(n:Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImagenClickable(R.drawable.raton) {

        }

        Spacer(modifier = Modifier.height(16.dp))

        ImagenClickable(R.drawable.vaca) {

        }
    }
}

@Composable
fun ImagenClickable(@DrawableRes pictograma: Int, onClick: () -> Unit) {
    PictureCard(imageURL = pictograma) {}
}