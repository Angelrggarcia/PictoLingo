package com.example.pictolingo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.example.pictolingo.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenPictograms(navController: NavHostController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            TopBar(navController, scrollBehavior)
        },

    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            PictogramGrid()
        }
    }
}

@Composable
fun PictogramGrid() {
    val count = remember { mutableStateOf(0) }
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
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    )
}
