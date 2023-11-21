package com.example.pictolingo.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pictolingo.components.PictureCard
import com.example.pictolingo.components.TopBar
import com.example.pictolingo.objects.PictogramPack
import com.example.pictolingo.objects.getPictogramPacks

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenPictogramCategory(navController: NavHostController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            TopBar(navController, scrollBehavior, "UsersScreen", "Levels")
        },

        ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            PictogramCategoryGrid(getPictogramPacks(), navController)
        }
    }
}

@Composable
fun PictogramCategoryGrid(pictogramPacks: List<PictogramPack>,navController: NavHostController) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        content = {
            item(span = {
                GridItemSpan(maxLineSpan)
            }){
                Text(modifier = Modifier
                    .fillMaxWidth(),
                    text = "Categorias",
                    textAlign = TextAlign.Center,
                    fontSize = 45.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif)
            }
            items(items = pictogramPacks){ it ->
                val enClick: () -> Unit = {navController.navigate("Pictograms")}
                PictureCard(it.name, it.picture, enClick)
            }
        },
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    )
}