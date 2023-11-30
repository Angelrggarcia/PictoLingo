package com.example.pictolingo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.pictolingo.R
import com.example.pictolingo.objects.Level

@Composable
fun LevelSmall(level: Level, navController:NavHostController) {
    Box(modifier = Modifier
        .padding(horizontal = 30.dp, vertical = 15.dp)
        .border(width = 2.dp, color = Color(0xFF000000), shape = RoundedCornerShape(15.dp))
        .clip(RoundedCornerShape(15.dp))
        .background(brush = Brush.horizontalGradient(
            listOf(
                level.color,
                Color(0xFFD9D9D9),
                level.color
            )
        ))
        .height(80.dp)
        .fillMaxWidth()
        .clickable { navController.navigate(level.route) },
        contentAlignment = Alignment.Center
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ){
            Image(
                painterResource(id = level.emoji),
                contentDescription = "Level face",
                Modifier
                    .padding(horizontal = 15.dp, vertical = 5.dp)
                    .fillMaxHeight()
                    .weight(1.5f)
                    .align(Alignment.CenterVertically)
            )
            Text(
                text = level.name,
                style = MaterialTheme.typography.displayMedium.copy(fontSize = 30.sp),
                textAlign = TextAlign.Left,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF000000),
                modifier = Modifier
                    .weight(4f)
                    .align(Alignment.CenterVertically)
                    .padding(horizontal = 10.dp)
            )
            Column(
                modifier = Modifier
                    .weight(2f)
                    .align(Alignment.CenterVertically)
                    .padding(horizontal = 10.dp)
                    .offset(y = 7.dp)
                    .fillMaxWidth()
            ){
                AsyncImage(
                    model = R.drawable.estrellas,
                    contentDescription = "Stars",
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Text(
                    text = (level.count).toString(),
                    textAlign = TextAlign.Center,

                    style = MaterialTheme.typography.displayMedium.copy(fontSize = 25.sp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = (-15).dp)
                )
            }
        }

    }
}