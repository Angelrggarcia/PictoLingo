package com.example.pictolingo.screens.games

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pictolingo.R
import kotlinx.coroutines.delay


data class MemoryCard(
    val id: Int,
    val pictogramImage: Int,
    var isFaceUp: Boolean = false,
    var isMatched: Boolean = false
)

fun getPictogramSet(): List<MemoryCard> {
    val pictograms = listOf(R.drawable.ajolote, R.drawable.osito, R.drawable.perrito,
        R.drawable.pingui,R.drawable.ranita, R.drawable.tigre, R.drawable.zorro)
    val memoryCards = pictograms.flatMap {
        listOf(MemoryCard(it, it), MemoryCard(it, it))
    }.shuffled()
    return memoryCards
}

class MemoryGameViewModel: ViewModel() {

    var cards: List<MemoryCard> by mutableStateOf(listOf())
    private var indexOfSingleSelectedCard: Int? = null
    var needToResetCards: Boolean by mutableStateOf(false)

    var gameCompleted: Boolean by mutableStateOf(false)
        private set

    init {
        cards = getPictogramSet()
    }

    fun onCardClicked(clickedIndex: Int) {
        val newCards = cards.toMutableList()
        val clickedCard = newCards[clickedIndex]

        if (indexOfSingleSelectedCard == null) {

            indexOfSingleSelectedCard = clickedIndex
            newCards[clickedIndex] = clickedCard.copy(isFaceUp = true)
        } else {

            if (newCards[indexOfSingleSelectedCard!!].pictogramImage == clickedCard.pictogramImage) {

                newCards[clickedIndex] = clickedCard.copy(isFaceUp = true, isMatched = true)
                newCards[indexOfSingleSelectedCard!!] = newCards[indexOfSingleSelectedCard!!].copy(isMatched = true)
            } else {

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
            .size(102.dp)
            .clickable { onCardClick(card.id) }
    ) {
        if (card.isFaceUp) {
            Image(
                painter = painterResource(id = card.pictogramImage),
                contentDescription = "Pictograma",
                modifier = Modifier.fillMaxSize()
            )
        } else {

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

    val columns = if (isPortrait) 3 else 5

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
fun MemoryGameScreen(viewModel: MemoryGameViewModel = viewModel()) {
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
                delay(1000)
                viewModel.resetCards()
            }
        }

        if (gameCompleted) {
            AlertDialog(
                onDismissRequest = { viewModel.restartGame() },
                title = { Text("Juego Completado") },
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