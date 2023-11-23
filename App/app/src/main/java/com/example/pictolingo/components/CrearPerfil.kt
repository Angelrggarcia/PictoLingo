package com.example.pictolingo.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pictolingo.ui.theme.azul_verdoso
import com.example.pictolingo.ui.theme.blaco
import com.example.pictolingo.ui.theme.gris
import com.example.pictolingo.ui.theme.hueso
import com.example.pictolingo.ui.theme.md_theme_light_onPrimaryContainer
import com.example.pictolingo.ui.theme.otro_blaco

@Composable
fun CrearPerfil( onCreatePerfil : () -> Unit ){

    var screen by remember { mutableStateOf(1) }

    when(screen) {
        1 -> {Login { screen = 2 } }
        2 -> {Perfil{ onCreatePerfil() }}
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(onScreenChange : () -> Unit) {
    var usuario by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .background(color = otro_blaco, shape = RoundedCornerShape(40.dp))
            .border(width = 4.dp, color = hueso, shape = RoundedCornerShape(40.dp))
            .fillMaxWidth(0.75f),
        contentAlignment = Alignment.TopCenter,
    ){
        Column(
            modifier = Modifier
                .padding(10.dp),
        ) {
            Text(
                text = "Crear un perfil",
                color = md_theme_light_onPrimaryContainer,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
            )
            Text(
                text = "Inicia con perfil de administrador",
                color = md_theme_light_onPrimaryContainer,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
            )
            Text(
                text = "Usuario: ",
                modifier = Modifier
                    .padding(10.dp)
            )
            OutlinedTextField(
                value = usuario,
                onValueChange = { usuario = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Localized description",
                    )
                },
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(),
            )
            Text(
                text = "Contraseña: ",
                modifier = Modifier
                    .padding(10.dp)
            )
            OutlinedTextField(
                value = contrasena,
                onValueChange = { contrasena = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "Localized description",
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(),
            )
            Button(
                onClick = { onScreenChange() },
                colors = buttonColors(
                    containerColor = azul_verdoso,
                    contentColor = blaco,
                    disabledContainerColor = gris,
                    disabledContentColor = blaco,
                ),
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text (
                    "Confirmar"
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Perfil(onCreatePerfil : () -> Unit) {

    var nombre by remember { mutableStateOf("") }
    var codigo by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .background(color = otro_blaco, shape = RoundedCornerShape(40.dp))
            .border(width = 4.dp, color = hueso, shape = RoundedCornerShape(40.dp))
            .fillMaxWidth(0.75f),
        contentAlignment = Alignment.TopCenter,
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp),
        ) {
            Text(
                text = "Crear un perfil",
                color = md_theme_light_onPrimaryContainer,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
            )
            Text(
                text = "Nombre: ",
                modifier = Modifier
                    .padding(10.dp)
            )
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Localized description",
                    )
                },
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(),
            )
            Row (Modifier.fillMaxWidth()) {
                Column (Modifier.weight(2f)) {
                    Text(
                        text = "Código de alumno: ",
                        modifier = Modifier
                            .padding(10.dp)
                    )
                    OutlinedTextField(
                        value = codigo,
                        onValueChange = { codigo = it },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Person,
                                contentDescription = "Localized description",
                            )
                        },
                        modifier = Modifier
                            .padding(10.dp)
                            .align(Alignment.CenterHorizontally),
                    )
                }
                Column (Modifier.weight(1f)) {
                    Text(
                        text = "Edad: ",
                        modifier = Modifier
                            .padding(10.dp)
                    )
                    OutlinedTextField(
                        value = edad,
                        onValueChange = { edad = it },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Person,
                                contentDescription = "Localized description",
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .padding(10.dp)
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(),
                    )
                }
            }
            Button(
                onClick = { onCreatePerfil() },
                colors = buttonColors(
                    containerColor = azul_verdoso,
                    contentColor = blaco,
                    disabledContainerColor = gris,
                    disabledContentColor = blaco,
                ),
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text (
                    "Confirmar"
                )
            }
        }
    }
}
