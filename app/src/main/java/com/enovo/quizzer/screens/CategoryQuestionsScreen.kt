//package com.enovo.quizzer.screens
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.material.Button
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavHostController
//import com.enovo.quizzer.data.questionList
//
//@Composable
//fun CategoryQuestionsScreen(navController: NavHostController, categoryName: String) {
//    // Filter the questions based on the category
//    val filteredQuestions = questionList.filter { it.category == categoryName }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.SpaceBetween
//    ) {
//        Text(
//            text = "Questions for $categoryName",
//            style = MaterialTheme.typography.h4,
//            modifier = Modifier.padding(bottom = 16.dp)
//        )
//
//        // Display the questions related to the selected category
//        LazyColumn(
//            modifier = Modifier.fillMaxWidth(),
//            verticalArrangement = Arrangement.spacedBy(8.dp)
//        ) {
//            itemsIndexed(filteredQuestions) { index, question ->
//                Column(
//                    modifier = Modifier.fillMaxWidth()
//                ) {
//                    Text(
//                        text = question.text,
//                        style = MaterialTheme.typography.h6,
//                        modifier = Modifier.padding(bottom = 8.dp)
//                    )
//
//                    // Optionally display the options as buttons
//                    question.options.forEach { option ->
//                        Button(
//                            onClick = {
//                                // Handle the answer click (e.g., check if it's correct)
//                            },
//                            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
//                        ) {
//                            Text(text = option)
//                        }
//                    }
//                }
//            }
//        }
//
//        // Go back button
//        Button(
//            onClick = { navController.popBackStack() },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 16.dp)
//        ) {
//            Text(text = "Go Back")
//        }
//    }
//}
//
