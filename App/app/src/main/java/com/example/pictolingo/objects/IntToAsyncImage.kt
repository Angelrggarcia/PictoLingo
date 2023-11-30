package com.example.pictolingo.objects

import androidx.compose.runtime.Composable
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter

@Composable
fun intToAsync(picture: Int): AsyncImagePainter {
    return rememberAsyncImagePainter(
        model = picture
    )
}