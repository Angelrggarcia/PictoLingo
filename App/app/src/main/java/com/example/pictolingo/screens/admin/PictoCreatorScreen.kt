package com.example.pictolingo.screens.admin

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
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
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.pictolingo.R
import com.example.pictolingo.components.ColorCard
import com.example.pictolingo.components.MiViewModel
import com.example.pictolingo.components.PictureCard
import com.example.pictolingo.components.TopBar
import com.example.pictolingo.objects.Pictogram
import com.example.pictolingo.objects.getColorList
import com.example.pictolingo.screens.users.savePicto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenPictogramCreator(navController: NavHostController,viewModel: MiViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            TopBar(navController, scrollBehavior, "AdminPictograms")
        },

        ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Creator(viewModel)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Creator(viewModel: MiViewModel) {
    var color by remember { mutableStateOf(Color(0xFFB2C8E8)) }
    var name by remember { mutableStateOf("") }
    var bool by remember { mutableStateOf(false)}
    var description by remember { mutableStateOf("")}
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    var imageUris = remember {
        mutableListOf<Uri>()
    }
    val singlePhotoLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {uri -> imageUri = uri},
        )
    val MultiplePhoroLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickMultipleVisualMedia(),
        onResult = {uris -> imageUris = uris.toMutableList() },
    )

    val painter = rememberAsyncImagePainter(imageUri.value.ifEmpty { R.drawable.suma })



    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(start = 40.dp, end = 40.dp)
    ) {
        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Crea un Pictograma!!",
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
                    PictureCard(
                        name = "Crea un nuevo Pictograma",
                        color = color,
                        imageURL = painter
                    ) {
                        MultiplePhoroLauncher.launch(
                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                    }
                }

                Column {
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
                            LazyHorizontalGrid(
                                rows = GridCells.Fixed(1),
                                content = {
                                    items(items = getColorList()) {
                                        ColorCard(color = it) {
                                            color = it
                                        }
                                    }

                                }, modifier = Modifier
                                    .padding(10.dp)
                                    .height(80.dp)
                                    .fillMaxWidth()
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
        item {

            Button(onClick = { bool = true }) {
                Text(text = "Guardar")
            }
            if (bool) {
                viewModel.lista =
                    savePicto(name = name, color = color, picture = painter, list = viewModel.lista)
                bool = false
            }
        }
        item{
            AsyncImage(
                model = imageUri,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop)
        }

        items(imageUris){uri ->
            AsyncImage(
                model = uri, contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop)
        }
    }

}
