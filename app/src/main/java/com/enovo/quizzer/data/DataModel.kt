package com.enovo.quizzer.data
import com.enovo.quizzer.R

 class QuizQuestion(
    val text: String,
    val options: List<String>,
    val correctAnswer: String,
    val imageResId: Int,
    val category: String // Add category to associate each question with a category
)


data class Player(
    val nickname: String,
    val subject: String,
    val score: Int,
    val imageResId: Int
)

