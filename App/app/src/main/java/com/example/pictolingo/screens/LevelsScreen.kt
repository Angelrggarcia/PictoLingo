package com.example.pictolingo.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.pictolingo.components.LevelSmall
import com.example.pictolingo.components.TopBar
import com.example.pictolingo.objects.getLevels

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LevelsScreen(navController: NavHostController) {
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
            Levels()
        }
    }
}

@Composable
fun Levels() {
    LazyColumn(content = {
        item{
            Text(modifier = Modifier
                .padding(vertical = 15.dp)
                .fillMaxWidth(),
                text ="Niveles",
                textAlign = TextAlign.Center,
                fontSize = 45.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif)
        }
        items(items = getLevels()){ it ->
            LevelSmall(it)
        }
        item {

        }
    })
}