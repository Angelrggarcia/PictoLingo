package com.example.pictolingo

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pictolingo.screens.LevelsScreen
import com.example.pictolingo.screens.LoginScreen
import com.example.pictolingo.screens.ScreenPictograms
import com.example.pictolingo.screens.TestScreen
import com.example.pictolingo.screens.UsersScreen

@Composable
fun Nav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Login"){
        composable(route = "Login"){
            LoginScreen(navController)
        }
        composable(route = "Pictograms"){
            ScreenPictograms(navController)
        }
        composable(route = "UsersScreen"){
            UsersScreen(navController)
        }
        composable(route = "Test"){
            TestScreen(navController)
        }
        composable(route = "Levels"){
            LevelsScreen(navController)
        }
    }
}
