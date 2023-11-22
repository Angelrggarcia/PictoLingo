package com.example.pictolingo.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pictolingo.ui.theme.hueso
import com.example.pictolingo.ui.theme.md_theme_light_onPrimaryContainer
import com.example.pictolingo.ui.theme.otro_blaco

// se encarga de generar la funcion para mandar codigos y traer el perfil
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CargarPerfil(navController : NavHostController){
    var text by rememberSaveable { mutableStateOf("") }

    Column() {

        Box(
            modifier = Modifier
                .fillMaxWidth(.75f)
                .align(Alignment.CenterHorizontally)
                .padding(8.dp)
                .background(
                    color = otro_blaco,
                    shape = RoundedCornerShape(40.dp))
                .border(width = 4.dp, color = hueso, shape = RoundedCornerShape(40.dp)),

            contentAlignment = Alignment.TopCenter
        ){
            Column {
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    text = "Introduce el codigo del perfil que desea cargar.",
                    color = md_theme_light_onPrimaryContainer,
                    fontSize = 50.sp,
                    lineHeight = 1.2.em,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center


                )
                Text(
                    text = "Favor de introducir el texto de 10 dígitos dados por el administrador",
                    color = md_theme_light_onPrimaryContainer,
                    fontSize = 20.sp,
                    lineHeight = 1.2.em,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center


                )
                OutlinedTextField(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth(.50f),
                    value =  text,
                    onValueChange = {
                        // Filtrar para permitir solo números
                        val newText = it.filter { char -> char.isDigit() }
                        text = newText
                    },
                    trailingIcon = {
                        Icon(
                            Icons.Filled.Clear,
                            contentDescription = null,
                            modifier = Modifier.clickable {
                                text = "" }) },
                    label = { Text("Poner el codigo") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number

                    )
                )
                Button(onClick = {
                    navController.navigate("AdminPictogramCat")
                },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                        .padding(16.dp)

                    ) {
                    Text(text = "Enviar")
                }

            }


        }

    }
}


