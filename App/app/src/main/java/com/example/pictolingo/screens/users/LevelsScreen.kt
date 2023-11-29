package com.example.pictolingo.screens.users

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pictolingo.components.LevelSmall
import com.example.pictolingo.components.TopBar
import com.example.pictolingo.objects.getLevels
import com.example.pictolingo.ui.theme.azul_verdoso

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LevelsScreen(navController: NavHostController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            TopBar(navController, scrollBehavior, "Main")
        },

        ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Levels(navController)
        }
    }
}

@Composable
fun Levels(navController: NavHostController) {
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
            OutlinedButton(
                modifier = Modifier
                    .padding(top = 35.dp),

                onClick = {navController.navigate("Categories")},
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color(0xFF18D2B6)
                ),
                border = BorderStroke(
                    width = 2.dp,

                    brush = Brush.horizontalGradient(
                        listOf(
                            Color(0xFF18D2B6),
                            Color(0xFFFF595E)
                        )
                    )
                )
            ) {
                Text(text ="Pictogramas",
                    color = Color(0xFF18D2B6),
                    textAlign = TextAlign.Center,
                    fontSize = 45.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif)
            }
        }
        item{
            OutlinedButton(
                modifier = Modifier
                    .padding(top = 35.dp),

                onClick = { navController.navigate ("miniGames")},
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color(0xFF1D2BB6)
                ),
                border = BorderStroke(
                    width =  2.dp,
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color(0xFF18D2B6),
                            Color(0xFFFF595E)
                        )
                    )

                )
            ){
                Text(text = "Minijuegos",
                    color = azul_verdoso,
                    textAlign = TextAlign.Center,
                    fontSize = 45.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif)
            }
        }
    }, horizontalAlignment = Alignment.CenterHorizontally)
}