package com.example.pictolingo.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorCard(color: Color, enClick: () -> Unit) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .padding(horizontal = 10.dp)
                .clip(RoundedCornerShape(40.dp))
                .background(Color(0xFFFFFFFF))
                .clickable { enClick() }
                .border(4.dp, Color.Black, shape = RoundedCornerShape(40.dp)),
            contentAlignment = Alignment.Center
        )   {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .clip(RoundedCornerShape(40.dp))
                    .background(color)
            )
        }
    }
