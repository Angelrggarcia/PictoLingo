package com.example.pictolingo.screens.users

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImagePainter
import com.example.pictolingo.components.MiViewModel
import com.example.pictolingo.components.PictureCard
import com.example.pictolingo.components.TopBar
import com.example.pictolingo.components.textToSpeech
import com.example.pictolingo.objects.Pictogram
import com.example.pictolingo.objects.PictogramPack
import com.example.pictolingo.objects.getPictogramPacks

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenPictograms(navController: NavHostController,viewModel: MiViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            TopBar(navController, scrollBehavior, "Categories")
        },

    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            PictogramGrid(getPictogramPacks()[0],viewModel)
        }
    }
}

@Composable
fun PictogramGrid(pictogramPack: PictogramPack,viewModel: MiViewModel) {
    val context = LocalContext.current
    val newPictogram by remember { mutableStateOf(emptyList<Pictogram>()) }
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        content = {
            item(span = {
                GridItemSpan(maxLineSpan)
            }){
                Text(modifier = Modifier
                    .fillMaxWidth(),
                    text = pictogramPack.name,
                    textAlign = TextAlign.Center,
                    fontSize = 45.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif)
            }
            items(items = pictogramPack.anagrams){

                PictureCard(it.name,it.color,it.picture) { textToSpeech(it.name, context) }

            }
            items(items = newPictogram){
                PictureCard(it.name,it.color,it.picture) { textToSpeech(it.name, context) }
            }
        },
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    )
}

@Composable
fun savePicto(
    name: String,
    color: Color,
    picture: AsyncImagePainter,
    list: List<Pictogram>
): MutableList<Pictogram> {
    val copy:MutableList<Pictogram> = ArrayList(list)
    copy.add(Pictogram(name, picture, color))
    return copy
}
