package com.example.pictolingo.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pictolingo.ui.theme.hueso
import com.example.pictolingo.ui.theme.md_theme_light_onPrimaryContainer
import com.example.pictolingo.ui.theme.otro_blaco

// se encarga de generar la funcion para mandar codigos y traer el perfil
@Composable
fun CargarPerfil(navController : NavHostController){

    Column {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .background(color = otro_blaco)
                .border(width = 4.dp, color = hueso, shape = RoundedCornerShape(40.dp) )
                .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ){
            Column {
                Text(
                    text = "Introduce el codigo del perfil que desea cargar.",
                    color = md_theme_light_onPrimaryContainer,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
                Button(onClick = {
                    navController.navigate("AdminPictogramCat")
                }) {
                    Text(text = "Enviar")
                }
            }


        }

    }
}
