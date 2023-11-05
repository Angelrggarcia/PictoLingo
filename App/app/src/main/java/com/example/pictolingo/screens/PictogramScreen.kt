package com.example.pictolingo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import com.example.pictolingo.components.PictureCard
import com.example.pictolingo.components.TopBar
import com.example.pictolingo.objects.AnagramPack
import com.example.pictolingo.objects.getAnagramPacks

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
            PictogramGrid(getAnagramPacks()[0])
        }
    }
}

@Composable
fun PictogramGrid(anagramPack: AnagramPack) {
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
                        text = anagramPack.name,
                        textAlign = TextAlign.Center,
                        fontSize = 45.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif)
                }
            }
            items(items = anagramPack.anagrams){ it ->
                val enClick: () -> Unit = {}
                PictureCard(it.name, it.urlPicture, enClick)
            }
        },
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    )
}
