package com.example.pictolingo.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pictolingo.components.ColorCard
import com.example.pictolingo.components.PictureCard
import com.example.pictolingo.components.TopBar
import com.example.pictolingo.objects.getColorList
import com.example.pictolingo.objects.getUsers

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenPictogramCreator(navController: NavHostController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            TopBar(navController, scrollBehavior, "AdminPictograms", "Test")
        },

        ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Creator()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Creator() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 40.dp, start = 40.dp, end = 40.dp)){
        Text(modifier = Modifier
            .fillMaxWidth(),
            text = "Crea un Pictograma!!",
            textAlign = TextAlign.Center,
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif)
        Row(){
            Box(modifier = Modifier
                .fillMaxWidth(1/3f)){
                PictureCard(name = "Crea un nuevo Pictograma", imageURL = 0,){
                }
            }

            Column{
                var name by remember { mutableStateOf("")}
                var description by remember { mutableStateOf("")}
                Box(modifier = Modifier
                    .fillMaxHeight(1/3f),
                    contentAlignment = Alignment.TopCenter
                    ){
                    Column {
                        OutlinedTextField(
                            value = name,
                            onValueChange = { name = it },
                            label = { Text("Nombre") })
                        LazyHorizontalGrid(rows = GridCells.Fixed(1),
                            content ={
                                items(items = getColorList()){
                                    ColorCard(color = 0xFFFFFFFF){}}

                            })
                    }
                }
                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Descripcion") })
            }
        }
    }
}