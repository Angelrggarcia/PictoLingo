package com.example.pictolingo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Top(navController: NavHostController){
    Box(modifier = Modifier
        .background(Color(0xFF314350))
        .fillMaxHeight(1 / 9f)
        .fillMaxWidth(),
        contentAlignment = Alignment.Center){
        Row(modifier = Modifier
            .padding(horizontal = 25.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically){
            Image(
                modifier = Modifier
                    .clickable{
                        navController.navigate("Main"){
                            popUpTo("Main"){inclusive = true}
                        }
                    },
                painter = painterResource(id = R.drawable.flechita),
                contentDescription = null
            )
            Image(
                modifier = Modifier
                    .clickable{
                        navController.navigate("Test")
                    },
                painter = painterResource(id = R.drawable.options),
                contentDescription = null
            )

        }
    }
}


@Composable
fun ScreenPictograms(navController: NavHostController) {

    val count = remember { mutableStateOf(0) }
    Column {
        Top(navController)
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            content = {
                item(span = {
                    GridItemSpan(maxLineSpan)
                }){
                    Box(modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFFB2C8E8))
                        .height(100.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Text(modifier = Modifier
                            .fillMaxWidth(),
                            text ="Frutas",
                            textAlign = TextAlign.Center,
                            fontSize = 45.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif)
                    }
                }
                items(100){i ->
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .aspectRatio(1f)
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color(0xFFB2C8E8))
                            .clickable { count.value += 1 },
                        contentAlignment = Alignment.Center
                    ){
                        Image(
                            modifier = Modifier
                                .padding(10.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            painter = painterResource(id = R.drawable.abeja),
                            contentDescription = null
                        )
                    }
                }
            },
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp))
    }

}