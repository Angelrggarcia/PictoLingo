package com.example.pictolingo

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pictolingo.objects.ElMemorias
import com.example.pictolingo.objects.Level
//import com.example.pictolingo.objects.PuzzlesScreens
import com.example.pictolingo.screens.admin.AdminScreenPictograms
import com.example.pictolingo.screens.users.LevelsScreen
import com.example.pictolingo.screens.admin.ScreenCategoryCreator
import com.example.pictolingo.screens.users.ScreenPictogramCategory
import com.example.pictolingo.screens.admin.ScreenPictogramCategoryAdmin
import com.example.pictolingo.screens.admin.ScreenPictogramCreator
import com.example.pictolingo.screens.users.ScreenPictograms
import com.example.pictolingo.screens.LoginScreen
import com.example.pictolingo.screens.games.JuegoDePictogramas
import com.example.pictolingo.screens.games.JuegoLetras
import com.example.pictolingo.screens.games.JuegosNumeros
import com.example.pictolingo.screens.games.LetrasGame
import com.example.pictolingo.screens.games.puzzle.HiLowsGams
import com.example.pictolingo.screens.games.puzzle.PuzzlesScreens
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
        composable(route = "HiLowGame"){
            HiLowsGams(navController)
        }
        composable(route = "PuzGame"){
            PuzzlesScreens(navController)
        }
        composable(route = "Jletras"){
            JuegoLetras(navController)
        }
        composable(route = "MemoGame"){
            ElMemorias(navController)
        }
    }
}
