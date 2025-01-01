package com.enovo.quizzer.data
import com.enovo.quizzer.R

 class QuizQuestion(
    val text: String,
    val options: List<String>,
    val correctAnswer: String,
    val imageResId: Int,
    val category: String // Add category to associate each question with a category
)

// List of quiz questions categorized by topic
val questionList = listOf(
    QuizQuestion(
        text = "Is Apple a large technology company?",
        options = listOf("Yes", "No"),
        correctAnswer = "Yes",
        imageResId = R.drawable.math, // Replace with your image resource
        category = "Technology"
    ),
    QuizQuestion(
        text = "Is Tesla a food company?",
        options = listOf("Yes", "No"),
        correctAnswer = "No",
        imageResId = R.drawable.general_knowledge2, // Replace with your image resource
        category = "General Knowledge"
    ),
    QuizQuestion(
        text = "Is Python a programming language?",
        options = listOf("Yes", "No"),
        correctAnswer = "Yes",
        imageResId = R.drawable.computer_science, // Replace with your image resource
        category = "Programming"
    ),
    QuizQuestion(
        text = "Is the Earth flat?",
        options = listOf("Yes", "No"),
        correctAnswer = "No",
        imageResId = R.drawable.geography, // Replace with your image resource
        category = "Geography"
    ),
    QuizQuestion(
        text = "What is the capital of France?",
        options = listOf("Paris", "Berlin", "Madrid"),
        correctAnswer = "Paris",
        imageResId = R.drawable.geography, // Replace with your image resource
        category = "Geography"
    ),
    QuizQuestion(
        text = "What is the chemical symbol for water?",
        options = listOf("H2O", "O2", "CO2", "H2"),
        correctAnswer = "H2O",
        imageResId = R.drawable.math, // Replace with your image resource
        category = "Chemistry"
    ),
    QuizQuestion(
        text = "What is the largest planet in our solar system?",
        options = listOf("Earth", "Mars", "Jupiter"),
        correctAnswer = "Jupiter",
        imageResId = R.drawable.science, // Replace with your image resource
        category = "Science"
    ),
    QuizQuestion(
        text = "Which animal is known as the 'King of the Jungle'?",
        options = listOf("Lion", "Tiger", "Tembo"),
        correctAnswer = "Lion",
        imageResId = R.drawable.player, // Replace with your image resource
        category = "Animals"
    ),
    QuizQuestion(
        text = "What is the smallest bone in the human body?",
        options = listOf("Stapes", "Femur", "Tibia"),
        correctAnswer = "Stapes",
        imageResId = R.drawable.geograpy2, // Replace with your image resource
        category = "Anatomy"
    ),
    QuizQuestion(
        text = "Which element is represented by the symbol 'O'?",
        options = listOf("Oxygen", "Osmium", "Ozone"),
        correctAnswer = "Oxygen",
        imageResId = R.drawable.general_knowledge, // Replace with your image resource
        category = "Chemistry"
    ),
    QuizQuestion(
        text = "What is the largest continent by land area?",
        options = listOf("Asia", "Africa", "Europe"),
        correctAnswer = "Asia",
        imageResId = R.drawable.geography, // Replace with your image resource
        category = "Geography"
    ),
    QuizQuestion(
        text = "Who developed the theory of relativity?",
        options = listOf("Isaac Newton", "Albert Einstein"),
        correctAnswer = "Albert Einstein",
        imageResId = R.drawable.science, // Replace with your image resource
        category = "Science"
    ),
    QuizQuestion(
        text = "What is the square root of 64?",
        options = listOf("6", "8", "10", "12"),
        correctAnswer = "8",
        imageResId = R.drawable.math, // Replace with your image resource
        category = "Mathematics"
    ),
    QuizQuestion(
        text = "Which language is spoken in Brazil?",
        options = listOf("Spanish", "Portuguese", "French"),
        correctAnswer = "Portuguese",
        imageResId = R.drawable.player, // Replace with your image resource
        category = "Languages"
    ),


    QuizQuestion(
        text = "If all roses are flowers and some flowers fade quickly, can we conclude that some roses fade quickly?",
        options = listOf("Yes", "No"),
        correctAnswer = "No",
        imageResId = R.drawable.general_knowledge2, // Replace with your image resource
        category = "IQ Test"
    ),

    QuizQuestion(
            text = "Which number should come next in the series: 2, 4, 8, 16, ...?",
            options = listOf("18", "32", "24", "64"),
            correctAnswer = "32",
            imageResId = R.drawable.general_knowledge, // Replace with your image resource
            category = "IQ Test"
    ),

    QuizQuestion(
           text = "What is the missing number in the sequence: 1, 4, 9, 16, ...?",
           options = listOf("25", "36", "20", "40"),
           correctAnswer = "25",
           imageResId = R.drawable.general_knowledge, // Replace with your image resource
           category = "IQ Test"
),

    QuizQuestion(
          text = "If the day after tomorrow is two days before Thursday, what day is it today?",
          options = listOf("Tuesday", "Wednesday", "Thursday"),
          correctAnswer = "Tuesday",
          imageResId = R.drawable.general_knowledge, // Replace with your image resource
          category = "IQ Test"
    ),

     QuizQuestion(
    text = "Which one of the following is the odd one out? 3, 5, 7, 9, 11",
     options = listOf("3", "5", "7", "9"),
     correctAnswer = "9",
     imageResId = R.drawable.math, // Replace with your image resource
     category = "IQ Test"
),

    QuizQuestion(
    text = "If you rearrange the letters 'CIFAIPC', you would have the name of a(n):",
    options = listOf("City", "Ocean", "Country"),
     correctAnswer = "Ocean",
     imageResId = R.drawable.math, // Replace with your image resource
       category = "IQ Test"
      )

)
