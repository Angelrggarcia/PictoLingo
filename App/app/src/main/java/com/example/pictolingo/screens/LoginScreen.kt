package com.example.pictolingo.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController


@Composable
fun LoginScreen(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()){
        Button(onClick = {
            navController.navigate("UsersScreen")
        }) {
            Text(text = "Login")
        }
        Button(onClick = {
            navController.navigate("AdminPictograms")
        }) {
            Text(text = "Admin")
        }
    }
}