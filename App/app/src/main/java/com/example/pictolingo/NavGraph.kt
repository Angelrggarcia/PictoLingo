package com.example.pictolingo

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pictolingo.screens.AdminScreenPictograms
import com.example.pictolingo.screens.LevelsScreen
import com.example.pictolingo.screens.LoginScreen
import com.example.pictolingo.screens.ScreenCategoryCreator
import com.example.pictolingo.screens.ScreenPictogramCategory
import com.example.pictolingo.screens.ScreenPictogramCategoryAdmin
import com.example.pictolingo.screens.ScreenPictogramCreator
import com.example.pictolingo.screens.ScreenPictograms
import com.example.pictolingo.screens.TestScreen
import com.example.pictolingo.screens.UsersScreen

@Composable
fun Nav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Main"){
        composable(route = "Main"){
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
        composable(route = "AdminPictograms"){
            AdminScreenPictograms(navController)
        }
        composable(route = "AdminPC"){
            ScreenPictogramCreator(navController)
        }
        composable(route = "Categories"){
            ScreenPictogramCategory(navController)
        }
        composable(route = "AdminPictogramCat"){
            ScreenPictogramCategoryAdmin(navController)
        }
        composable(route = "CatCreator"){
            ScreenCategoryCreator(navController)
        }
    }
}
