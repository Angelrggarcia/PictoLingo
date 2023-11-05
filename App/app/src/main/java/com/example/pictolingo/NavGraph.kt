package com.example.pictolingo

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pictolingo.screens.MainScreen
import com.example.pictolingo.screens.ScreenPictograms
import com.example.pictolingo.screens.TestScreen

@Composable
fun Nav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Main"){
        composable(route = "Main"){
            MainScreen(navController)
        }
        composable(route = "Pictograms"){
            ScreenPictograms(navController)
        }
        composable(route = "Test"){
            TestScreen(navController)
        }
    }
}
