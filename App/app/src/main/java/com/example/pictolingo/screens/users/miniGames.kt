package com.example.pictolingo.screens.users

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pictolingo.components.LevelSmall
import com.example.pictolingo.components.TopBar
import com.example.pictolingo.objects.getLevels
import com.example.pictolingo.ui.theme.azul_verdoso
import com.example.pictolingo.ui.theme.hueso
import com.example.pictolingo.ui.theme.otro_blaco


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Games(navHostController: NavHostController){
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopBar(navHostController, scrollBehavior, "Levels")
        },
        ) {innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            miniGames()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun miniGames(){
    LazyColumn( content = {
        item {
            Box(
                modifier = Modifier
                    .fillMaxSize(1f)
                    .padding(8.dp)
                    .background(
                        color = otro_blaco,
                        shape = RoundedCornerShape(40.dp))
                    .border(width = 4.dp, color = hueso, shape = RoundedCornerShape(40.dp)),

                contentAlignment = Alignment.TopCenter

            ){
                Text(
                    modifier = Modifier
                        .padding(vertical = 15.dp)
                        .fillMaxWidth(),
                    text = "Elige un Minijuego" ,
                    lineHeight = 1.2.em,
                    textAlign = TextAlign.Center,
                    fontSize = 45.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif)
            }
        }

    })
}
