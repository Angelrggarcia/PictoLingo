package com.example.pictolingo.screens

import android.content.res.Configuration
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pictolingo.components.PictureCard
import com.example.pictolingo.components.TopBar
import com.example.pictolingo.objects.getUsers
import com.example.pictolingo.components.SegmentedButtonItem
import com.example.pictolingo.components.SegmentedButtons
import com.example.pictolingo.components.CargarPerfil
import com.example.pictolingo.components.CrearPerfil
import com.example.pictolingo.ui.theme.blaco

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        containerColor = blaco,
        topBar = {
            TopBar(navController, scrollBehavior,"Login", false)
        },

        ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            UsersGrid(navController)
        }
    }
}

@Composable

fun UsersGrid(navController: NavHostController) {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    val gridCells = if (isLandscape){ 3 } else { 2 }

    var selectedIndex by remember { mutableStateOf(0) }

    LazyVerticalGrid(
        columns = GridCells.Fixed(gridCells),
        content = {
            item(span = {
                GridItemSpan(maxLineSpan)
            }){
                Text(modifier = Modifier
                    .fillMaxWidth(),
                    text ="Usuarios",
                    textAlign = TextAlign.Center,
                    fontSize = 45.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif)
            }

            item(span = {
                GridItemSpan(maxLineSpan)
            }){
                SegmentedButtons (modifier = Modifier.padding(horizontal = 20.dp)) {
                    SegmentedButtonItem(
                        selected = selectedIndex == 0,
                        onClick = { selectedIndex = 0 },
                        label = { Text(text = "Elige un perfil" )},
                    )
                    SegmentedButtonItem(
                        selected = selectedIndex == 1,
                        onClick = { selectedIndex = 1 },
                        label = { Text(text = "Cargar perfil") },
                    )
                    SegmentedButtonItem(
                        selected = selectedIndex == 2,
                        onClick = { selectedIndex = 2 },
                        label = { Text(text = "Crear perfil") },
                    )
                }
            }
            when(selectedIndex){
                0 -> {
                    items(items = getUsers()){ it ->
                        val enClick: () -> Unit = {navController.navigate("Levels")}
                        PictureCard(it.name, it.picture, enClick)
                    }
                    item {
                        PictureCard(name = "Crea un nuevo usuario", imageURL = 0) {}
                    }

                }
                1 -> {
                    item(span = {
                        GridItemSpan(maxLineSpan)
                    }){CargarPerfil(navController)}
                }
                2 -> {
                    item(span = {
                        GridItemSpan(maxLineSpan)
                    }){ CrearPerfil{ selectedIndex = 0 } }
                }
            }

        },
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    )
}
