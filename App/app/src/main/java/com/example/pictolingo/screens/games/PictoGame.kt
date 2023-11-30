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
import coil.compose.AsyncImagePainter
import com.example.pictolingo.R
import com.example.pictolingo.components.PictureCard
import com.example.pictolingo.objects.intToAsync

@Composable
fun JuegoDePictogramas(dificulty:Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val a_Image = intToAsync(picture = R.drawable.raton)
        ImagenClickable(a_Image) {

        }

        Spacer(modifier = Modifier.height(16.dp))
        val aImage = intToAsync(picture = R.drawable.vaca)
        ImagenClickable(aImage) {

        }
    }
}

@Composable
fun ImagenClickable(pictograma: AsyncImagePainter, onClick: () -> Unit) {
    PictureCard(imageURL = pictograma) {}
}