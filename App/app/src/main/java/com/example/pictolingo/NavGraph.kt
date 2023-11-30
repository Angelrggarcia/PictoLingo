package com.example.pictolingo

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pictolingo.objects.Level
import com.example.pictolingo.screens.admin.AdminScreenPictograms
import com.example.pictolingo.screens.users.LevelsScreen
import com.example.pictolingo.screens.admin.ScreenCategoryCreator
import com.example.pictolingo.screens.users.ScreenPictogramCategory
import com.example.pictolingo.screens.admin.ScreenPictogramCategoryAdmin
import com.example.pictolingo.screens.admin.ScreenPictogramCreator
import com.example.pictolingo.screens.users.ScreenPictograms
import com.example.pictolingo.screens.LoginScreen
import com.example.pictolingo.screens.games.JuegoDePictogramas
import com.example.pictolingo.screens.games.JuegosNumeros
import com.example.pictolingo.screens.games.LetrasGame
import com.example.pictolingo.screens.games.MemoryGameScreen
import com.example.pictolingo.screens.users.Games
import com.example.pictolingo.ui.theme.happy_face
import com.example.pictolingo.ui.theme.morado
import com.example.pictolingo.ui.theme.neutral_face
import com.example.pictolingo.ui.theme.rosa
import com.example.pictolingo.ui.theme.sad_face
import com.example.pictolingo.ui.theme.verde

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
        composable(route = "Games"){
            Games(navController)
        }
        composable(route = "NumGame"){
            JuegosNumeros(navController)
        }
//        Level("Medio", 42, happy_face, verde, "JuegoDePictogramas"),
//        Level("Difícil", 35, neutral_face, rosa, "MemoryGameScreen"),
//        Level("Muy difícil", 18, sad_face, morado, "LetrasGame"),
        composable(route = "JPictogramas"){
            JuegoDePictogramas(2)
        }
        composable(route = "JLetras"){
            LetrasGame()
        }
    }
}
