package com.enovo.quizzer.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.enovo.quizzer.R
import com.enovo.quizzer.data.Player
import kotlinx.coroutines.delay

@Composable
fun PlayerLeaderboard() {
    val playerList = listOf(
        Player("JohnDoe", "Biology", 90, R.drawable.player),
        Player("JaneSmith", "Geography", 85, R.drawable.math),
        Player("PlayerThree", "Science", 92, R.drawable.computer_science),
        Player("PikachuFan", "Plants", 88, R.drawable.player)
    )

    val state = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    // Auto-scrolling every 3 seconds
    LaunchedEffect(true) {
        while (true) {
            delay(1000) // Auto-scroll interval
            val firstVisibleItemIndex = state.firstVisibleItemIndex
            val totalItems = playerList.size
            val nextItemIndex = if (firstVisibleItemIndex + 1 < totalItems) {
                firstVisibleItemIndex + 1
            } else {
                0
            }
            state.animateScrollToItem(nextItemIndex)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = "Top Players",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyRow(
            state = state,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(playerList) { player ->
                PlayerCard(player)
            }
        }
    }
}

@Composable
fun PlayerCard(player: Player) {
    Card(
        modifier = Modifier
            .size(180.dp) // Adjust the size for player card
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            // Player Image (Avatar)
            Image(
                painter = painterResource(id = player.imageResId),
                contentDescription = "${player.nickname} image",
                modifier = Modifier
                    .size(100.dp) // Adjust size of the avatar
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )

            // Player Nickname
            Text(
                text = player.nickname,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 8.dp)
            )

            // Player Marks
            Text(
                text = "Marks: ${player.score}",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}


