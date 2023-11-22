package com.example.pictolingo.components

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    navController: NavHostController,
    scrollBehavior: TopAppBarScrollBehavior,
    backRoute: String,
    menuRoute: String,
    back: Boolean = true,
    menu: Boolean = true,
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = darkColorScheme().onSecondary,
        ),
        title = {},
        navigationIcon = {
            IconButton(
                onClick = { navController.navigate(backRoute) {
                    popUpTo("Login"){inclusive = true} }},
                ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Localized description",
                    tint = if (back) {
                        Color.White
                    } else {
                        Color.Transparent
                    },
                )
            }
        },
        actions = {
            IconButton(onClick = { navController.navigate(menuRoute) }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Localized description",
                    tint = if (menu) {
                        Color.White
                    } else {
                        Color.Transparent
                    },
                )
            }
        },
        scrollBehavior = scrollBehavior,
    )
}