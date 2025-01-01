package com.enovo.quizzer.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.*
import com.enovo.quizzer.data.questionList
import kotlinx.coroutines.delay

@Composable
fun QuizScreen(navController: NavHostController) {
    val quizQuestions = questionList // Replace with your quiz questions
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var selectedAnswer by remember { mutableStateOf("") }
    var timer by remember { mutableStateOf(10) }
    var showFeedback by remember { mutableStateOf(false) }
    var correctAnswers by remember { mutableStateOf(0) }
    var wrongAnswers by remember { mutableStateOf(0) }
    var quizFinished by remember { mutableStateOf(false) }
    val question = quizQuestions[currentQuestionIndex] // Get the question from the external file

    // Timer logic
    LaunchedEffect(timer) {
        if (timer > 0 && !quizFinished) {
            delay(1000L)
            timer--
        } else if (!quizFinished) {
            if (currentQuestionIndex < quizQuestions.size - 1) {
                currentQuestionIndex++
                selectedAnswer = ""
                timer = 10
                showFeedback = false
            } else {
                quizFinished = true
            }
        }
    }

    if (quizFinished) {
        // Display Results Screen with Animation for Pass
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (correctAnswers >= quizQuestions.size / 2) {
                // Lottie Animation for Success
                val composition by rememberLottieComposition(
                    LottieCompositionSpec.RawRes(com.enovo.quizzer.R.raw.congrats_animation) // Place your animation file in res/raw
                )
                val progress by animateLottieCompositionAsState(
                    composition = composition,
                    iterations = LottieConstants.IterateForever
                )

                LottieAnimation(
                    composition = composition,
                    progress = { progress },
                    modifier = Modifier.size(200.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Congratulations!",
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.Green,
                    fontWeight = FontWeight.Bold
                )
            } else {
                // Animation for failure
                val composition by rememberLottieComposition(
                    LottieCompositionSpec.RawRes(com.enovo.quizzer.R.raw.fail_animation) // Place your animation file in res/raw
                )
                val progress by animateLottieCompositionAsState(
                    composition = composition,
                    iterations = LottieConstants.IterateForever
                )

                LottieAnimation(
                    composition = composition,
                    progress = { progress },
                    modifier = Modifier.size(200.dp)
                )

                Text(
                    text = "Better luck next time!",
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Correct Answers: $correctAnswers/${quizQuestions.size}",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Green,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Wrong Answers: $wrongAnswers/${quizQuestions.size}",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Red,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("home") }) {
                Text(text = "Go Back to Home")
            }
        }
    } else {
        // Quiz Screen
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Section: Progress, Timer, and Score
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Science & Technology",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$timer s",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(0xFFFF5722),
                    fontWeight = FontWeight.Bold
                )
            }

            // Score Tracker
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Correct: $correctAnswers",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Green,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Wrong: $wrongAnswers",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                )
            }

            LinearProgressIndicator(
                progress = (10 - timer) / 10f,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            // Question Title
            Text(
                text = "Question ${currentQuestionIndex + 1}/${quizQuestions.size}",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            // Image with Border Radius
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .height(200.dp)
            ) {
                Image(
                    painter = painterResource(id = question.imageResId), // Image from QuizQuestion
                    contentDescription = "Question Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            // Question Text
            Text(
                text = question.text,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            // Answer Buttons
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                question.options.forEach { answer ->
                    Button(
                        onClick = {
                            if (selectedAnswer.isEmpty()) { // Prevent changing answer
                                selectedAnswer = answer
                                showFeedback = true
                                if (selectedAnswer == question.correctAnswer) {
                                    correctAnswers++
                                } else {
                                    wrongAnswers++
                                }
                            }
                        },
                        colors = if (selectedAnswer == answer)
                            ButtonDefaults.buttonColors(containerColor = if (answer == question.correctAnswer) Color.Green else Color.Red)
                        else ButtonDefaults.buttonColors()
                    ) {
                        Text(text = answer, fontSize = 18.sp)
                    }
                }
            }

            // Feedback for correct/incorrect answer
            if (showFeedback) {
                Text(
                    text = if (selectedAnswer == question.correctAnswer) "Correct!" else "Wrong!",
                    color = if (selectedAnswer == question.correctAnswer) Color.Green else Color.Red,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            // Next Button
            Button(
                onClick = {
                    if (currentQuestionIndex < quizQuestions.size - 1) {
                        currentQuestionIndex++
                        selectedAnswer = ""
                        timer = 10
                        showFeedback = false
                    } else {
                        quizFinished = true
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                enabled = showFeedback // Only allow Next when an answer is selected
            ) {
                Text(text = if (currentQuestionIndex < quizQuestions.size - 1) "Next" else "Finish")
            }
        }
    }
}
