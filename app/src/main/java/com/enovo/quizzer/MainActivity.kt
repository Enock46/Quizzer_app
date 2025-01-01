package com.enovo.quizzer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//import com.enovo.quizzer.screens.CategoryQuestionsScreen
import com.enovo.quizzer.screens.HomeScreen
import com.enovo.quizzer.screens.QuizScreen
import com.enovo.quizzer.ui.theme.QuizzerTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizzerTheme {
                QuizzerApp()
            }
        }
    }
}

@Composable
fun QuizzerApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("quiz") { QuizScreen(navController) }
//        composable("category_questions/{categoryName}") { backStackEntry ->
//            val categoryName = backStackEntry.arguments?.getString("categoryName") ?: ""
//            CategoryQuestionsScreen(navController, categoryName)
//        }
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QuizzerTheme {
        QuizzerApp()
    }
}
