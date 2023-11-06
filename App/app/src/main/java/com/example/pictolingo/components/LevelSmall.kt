package com.example.pictolingo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.pictolingo.objects.Level

@Composable
fun LevelSmall(level: Level) {
    Box(modifier = Modifier
        .padding(horizontal = 30.dp, vertical = 15.dp)
        .border(width = 2.dp, color = Color(0xFF000000), shape = RoundedCornerShape(15.dp))
        .clip(RoundedCornerShape(15.dp))
        .background(level.color)
        .height(60.dp)
        .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        Row{
            Image(
                painterResource(id = level.emoji),
                contentDescription = "Level face",
                Modifier
                    .fillMaxHeight()
                    .background(Color(0xFFFFFFFF), shape = CircleShape)
                    .weight(1f)
            )
            Text(
                text = level.name,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.weight(3f)
            )
            Column{
                Text(
                    text = (level.count).toString(),
                    modifier = Modifier.weight(1f)
                )
            }
        }

    }
}