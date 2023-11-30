package com.example.pictolingo.screens.admin

import android.content.ContentResolver
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.runtime.saveable.rememberSaveable
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
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.pictolingo.R
import com.example.pictolingo.components.ColorCard
import com.example.pictolingo.components.PictureCard
import com.example.pictolingo.components.SaveImage
import com.example.pictolingo.components.TopBar
import com.example.pictolingo.objects.getColorList
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCategoryCreator(navController: NavHostController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            TopBar(navController, scrollBehavior, "AdminPictogramCat")
        },

        ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            CatCreator()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatCreator() {
    var color by remember { mutableStateOf(Color(0xFFB2C8E8)) }
    val imageUri = rememberSaveable { mutableStateOf("") }
    var uriI by remember{ mutableStateOf<Uri>(Uri.parse("https://www.google.com")) }
    val painter = rememberAsyncImagePainter(imageUri.value.ifEmpty { R.drawable.suma })
    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()){
        uri: Uri? ->
        uri?.let {imageUri.value = it.toString()
            uriI = it
        }
    }

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(start = 40.dp, end = 40.dp)
    ) {
        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Crea una nueva Categoría!!",
                textAlign = TextAlign.Center,
                fontSize = 45.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif
            )
            Row {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(1 / 3f)
                ) {
                    PictureCard(name = "Crea una categoría", color = color, imageURL = painter) {
                        launcher.launch("image/*")
                        /*val imagen = SaveImage()
                        imagen.guardarImagenLocalmente(uriI)*/

                    }
                }

                Column {
                    var name by remember { mutableStateOf("") }
                    var description by remember { mutableStateOf("") }
                    Box(
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Column {
                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                value = name,
                                onValueChange = { name = it },
                                label = { Text("Nombre") })
                            LazyHorizontalGrid(rows = GridCells.Fixed(1),
                                content = {
                                    items(items = getColorList()) {
                                        ColorCard(color = it) {
                                            color = it
                                        }
                                    }

                                }, modifier = Modifier.padding(10.dp).height(80.dp).fillMaxWidth()
                            )
                        }
                    }
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = description,
                        onValueChange = { description = it },
                        label = { Text("Descripcion") })
                }
            }
        }
    }
}