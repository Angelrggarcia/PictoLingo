package com.example.pictolingo.components

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavHostController, scrollBehavior: TopAppBarScrollBehavior) {
    Log.d("COLOR", darkColorScheme().onSecondary.toString())
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = darkColorScheme().onSecondary,
        ),
        title = {},
        navigationIcon = {
            IconButton(onClick = { navController.navigate("Login"){
                popUpTo("Login"){inclusive = true}
            } }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Localized description",
                    tint = lightColorScheme().background,
                )
            }
        },
        actions = {
            IconButton(onClick = { navController.navigate("Levels") }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Localized description",
                    tint = lightColorScheme().background,
                )
            }
        },
        scrollBehavior = scrollBehavior,
    )
}