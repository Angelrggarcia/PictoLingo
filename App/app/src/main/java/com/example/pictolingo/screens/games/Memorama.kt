package com.example.pictolingo.objects

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.pictolingo.R
import com.example.pictolingo.components.TopBar
import com.example.pictolingo.screens.games.NumberGame
import com.example.pictolingo.ui.theme.azul_verdoso
import com.example.pictolingo.ui.theme.happy_face
import com.example.pictolingo.ui.theme.morado
import com.example.pictolingo.ui.theme.very_happy_face
import com.example.pictolingo.ui.theme.neutral_face
import com.example.pictolingo.ui.theme.rosa
import com.example.pictolingo.ui.theme.sad_face
import com.example.pictolingo.ui.theme.verde
import kotlinx.coroutines.delay


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElMemorias(navController: NavHostController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopBar(navController, scrollBehavior, "levels")
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            MemoryGameScreen()
        }
    }
}

data class MemoryCard(
    val id: Int,
    val pictogramImage: Int,
    var isFaceUp: Boolean = false,
    var isMatched: Boolean = false
)

fun getPictogramSet(): List<MemoryCard> {
    val pictograms = listOf(
        R.drawable.ajolote, R.drawable.osito, R.drawable.perrito,
        R.drawable.pingui,R.drawable.ranita, R.drawable.tigre, R.drawable.zorro)
    val memoryCards = pictograms.flatMap {
        listOf(MemoryCard(it, it), MemoryCard(it, it))
    }.shuffled()
    return memoryCards
}

class MemoryGameViewModel: ViewModel() {
    // Suponiendo que ya tienes una lista de tarjetas en tu ViewModel
    var cards: List<MemoryCard> by mutableStateOf(listOf())
    private var indexOfSingleSelectedCard: Int? = null
    var needToResetCards: Boolean by mutableStateOf(false)

    var gameCompleted: Boolean by mutableStateOf(false)
        private set

    init {
        // Inicializar las tarjetas
        cards = getPictogramSet()
    }

    fun onCardClicked(clickedIndex: Int) {
        val newCards = cards.toMutableList()
        val clickedCard = newCards[clickedIndex]

        if (indexOfSingleSelectedCard == null) {
            // Primera carta seleccionada
            indexOfSingleSelectedCard = clickedIndex
            newCards[clickedIndex] = clickedCard.copy(isFaceUp = true)
        } else {
            // Segunda carta seleccionada
            if (newCards[indexOfSingleSelectedCard!!].pictogramImage == clickedCard.pictogramImage) {
                // Las cartas coinciden
                newCards[clickedIndex] = clickedCard.copy(isFaceUp = true, isMatched = true)
                newCards[indexOfSingleSelectedCard!!] = newCards[indexOfSingleSelectedCard!!].copy(isMatched = true)
            } else {
                // Las cartas no coinciden
                newCards[clickedIndex] = clickedCard.copy(isFaceUp = true)
                needToResetCards = true
            }
            indexOfSingleSelectedCard = null
        }

        cards = newCards
        checkIfGameCompleted()

    }

    fun restartGame() {
        cards = getPictogramSet()
        gameCompleted = false
    }

    fun resetCards() {
        cards = cards.map { if (!it.isMatched) it.copy(isFaceUp = false) else it }
        needToResetCards = false
    }

    private fun checkIfGameCompleted() {
        gameCompleted = cards.all { it.isMatched }
    }
}

@Composable
fun MemoryCardView(card: MemoryCard, onCardClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .size(102.dp) // Establece el tamaño de la tarjeta para que sea un cuadrado
            .clickable { onCardClick(card.id) } // Acción al hacer clic en la tarjeta
    ) {
        if (card.isFaceUp) {
            Image(
                painter = painterResource(id = card.pictogramImage),
                contentDescription = "Pictograma",
                modifier = Modifier.fillMaxSize() // Asegúrate de que la imagen llene el Card
            )
        } else {
            // Mostrar el reverso de la tarjeta
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "??", style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
            }
        }
    }
}

@Composable
fun MemoryGameGrid(cards: List<MemoryCard>, onCardClick: (Int) -> Unit) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp
    val isPortrait = screenHeight > screenWidth

    val columns = if (isPortrait) 3 else 5 // Más columnas en modo paisaje

    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(cards.size) { index ->
            MemoryCardView(cards[index]) { onCardClick(index) }
        }
    }
}


@Composable
fun MemoryGameScreen(viewModel: MemoryGameViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val needToResetCards = viewModel.needToResetCards
    val gameCompleted = viewModel.gameCompleted

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "MEMORAMA",
            style = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LaunchedEffect(needToResetCards) {
            if (needToResetCards) {
                delay(1000) // Espera 1 segundo
                viewModel.resetCards()
            }
        }

        if (gameCompleted) {
            AlertDialog(
                onDismissRequest = { viewModel.restartGame() }, // Reinicia el juego cuando se cierra el diálogo
                title = {
                    Text("Juego Completado") },
                text = { Text("¡Felicidades, has completado con éxito el juego!") },
                confirmButton = {
                    Button(onClick = { viewModel.restartGame() }) {
                        Text("Cerrar")
                    }
                }
            )
        } else {
            MemoryGameGrid(cards = viewModel.cards) { clickedIndex ->
                viewModel.onCardClicked(clickedIndex)
            }
        }
    }
}