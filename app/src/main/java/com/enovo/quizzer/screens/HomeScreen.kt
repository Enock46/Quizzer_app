package com.enovo.quizzer.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.enovo.quizzer.R
import com.enovo.quizzer.data.PlayerLeaderboard

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp) // Spaced layout for better presentation
    ) {
        // Banner Section
        BannerSection(navController)

        Text(
            text = "Quiz Categories",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )

       //  LazyRow to display categories with improved performance and layout
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            val categories = listOf(
                "Biology" to R.drawable.biology,
                "Plants" to R.drawable.biology2,
                "Geography" to R.drawable.geography,
                "Science" to R.drawable.science2
            )

            items(categories, key = { it.first }) { (category, imageResId) ->
                CategoryCard(
                    categoryName = category,
                    imageResId = imageResId,
                    onCategoryClick = { selectedCategory ->
                        navController.navigate("category_questions/$selectedCategory")
                    }
                )
            }
        }

//        Button(
//            onClick = { navController.navigate("quiz") },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 16.dp)
//        ) {
//            Text(text = "Play Now")
//        }

        // Footer Section
        PlayerLeaderboard()
    }
}

@Composable
fun CategoryCard(
    categoryName: String,
    imageResId: Int,
    onCategoryClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .size(200.dp) // Size adjustment to fit image and text
            .padding(8.dp)
         //   .clickable { onCategoryClick(categoryName) },
        ,elevation =CardDefaults.cardElevation(18.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            // Circular Image with padding
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Subject categories image",
                modifier = Modifier
                    .size(120.dp) // Adjust size of the circular image
                    .clip(CircleShape)
            )

            // Category Name below the image
            Text(
                text = categoryName,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Composable
fun BannerSection(navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation =CardDefaults.cardElevation(18.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Quiz",
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = 40.sp
                )

                Text(
                    text = "Yourself",
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = 40.sp
                )

                Button(
                    onClick = { navController.navigate("quiz") },
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text(text = "Play Now")
                }
            }
            Image(
                painter = painterResource(id = R.drawable.winner2), // Replace with your trophy image resource
                contentDescription = "Trophy",
                modifier = Modifier
                    .size(135.dp)
                    .clip(CircleShape)
            )
        }
    }
}

//@Composable
//fun FooterSection(navController: NavHostController) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        // App version or credits
//        Text(
//            text = "App Version 1.0",
//            style = MaterialTheme.typography.bodySmall,
//            modifier = Modifier.padding(bottom = 8.dp)
//        )
//
//        // Settings or Help button
//        Button(
//            onClick = { navController.navigate("") }, // Modify this to your settings screen route
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text(text = "Settings")
//        }
//
//        // Alternatively, a "Help" button could be used here as well
//        Button(
//            onClick = { navController.navigate("") }, // Modify this to your help screen route
//
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text(text = "Help")
//        }
//    }
//}

@Composable
fun FooterSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display quiz progress
        ProgressBarSection(progress = 0.6f) // Example progress (60%)

        // Quiz stats
        Text(
            text = "Correct Answers: 12/20",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp)
        )

        // Suggest a random quiz button
        Button(
            onClick = { /* Add navigation to random quiz */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Try a Random Quiz")
        }
    }
}

@Composable
fun ProgressBarSection(progress: Float) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Progress", style = MaterialTheme.typography.bodySmall)

        // Progress Bar
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            color = MaterialTheme.colorScheme.primary
        )
    }
}