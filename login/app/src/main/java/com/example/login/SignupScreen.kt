package com.example.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreenPreview() {
    SignupScreen(rememberNavController())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,

    ){
        Image(
            painterResource(id = R.drawable.acuarela),///acuarela arriba
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer {
                    translationY = 270f
                    translationX = -10f
                    rotationZ = 150f
                    scaleX = 1.5f
                    scaleY = 1.5f
                }

        )
        Image(
            painter = painterResource(id = R.drawable.ninos),
            contentDescription = null,
            modifier = Modifier
                .height(220.dp)
                .graphicsLayer {
                    scaleX = 1.5f
                    scaleY = 1.5f
                }
        )
        Text("Crea una cuenta",
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            color = Color(android.graphics.Color.parseColor("#006064")),

            )

        var nombre by remember { mutableStateOf("Nombre Completo") }
        var email by remember { mutableStateOf("Email") }
        var password by remember { mutableStateOf("Contraseña") }
        var confPassword by remember { mutableStateOf("Confirma la contraseña") }

        var isNombreTouched by remember { mutableStateOf(false) }
        var isEmailTouched by remember { mutableStateOf(false) }
        var isPasswordTouched by remember { mutableStateOf(false) }
        var isConfPasswordTouched by remember { mutableStateOf(false) }
        var passwordVisible by rememberSaveable { mutableStateOf(false) }


        TextField(

            value = if(isNombreTouched) nombre else "Nombre Completo",
            onValueChange = { text ->
                isNombreTouched = true
                nombre = text
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(66.dp)
                .padding(start = 64.dp, end = 64.dp, top = 8.dp, bottom = 8.dp)
                .border(
                    1.dp,
                    Color(android.graphics.Color.parseColor("#006064")),
                    RoundedCornerShape(50)
                )
                .onFocusChanged { focusState ->
                    if (focusState.isFocused) {
                        isNombreTouched = true
                        if (nombre == "Nombre Completo") {
                            nombre = ""
                        }
                    } else {
                        if (nombre.isBlank()) {
                            isNombreTouched = false
                        }
                    }
                },

            singleLine = true,
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                color = Color(android.graphics.Color.parseColor("#006064")),
                fontSize = 14.sp
            ),
            shape = RoundedCornerShape(50.dp),
            placeholder = { Text("Nombre Completo", color = Color.Gray) },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(android.graphics.Color.parseColor("#006064")),
                cursorColor = Color(android.graphics.Color.parseColor("#006064")),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )

        TextField(

            value = if(isEmailTouched) email else "Email",
            onValueChange = { text ->
                isEmailTouched = true
                email = text
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(66.dp)
                .padding(start = 64.dp, end = 64.dp, top = 8.dp, bottom = 8.dp)
                .border(
                    1.dp,
                    Color(android.graphics.Color.parseColor("#006064")),
                    RoundedCornerShape(50)
                )
                .onFocusChanged { focusState ->
                    if (focusState.isFocused) {
                        isEmailTouched = true
                        if (email == "Email") {
                            email = ""
                        }
                    } else {
                        if (email.isBlank()) {
                            isEmailTouched = false
                        }
                    }
                },

            singleLine = true,
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                color = Color(android.graphics.Color.parseColor("#006064")),
                fontSize = 14.sp
            ),
            shape = RoundedCornerShape(50.dp),
            placeholder = { Text("Email", color = Color.Gray) },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(android.graphics.Color.parseColor("#006064")),
                cursorColor = Color(android.graphics.Color.parseColor("#006064")),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(keyboardType = androidx.compose.ui.text.input.KeyboardType.Email)
        )

        TextField(

            value = if(isPasswordTouched) password else "Contraseña",
            onValueChange = { text ->
                isPasswordTouched = true
                password = text
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(66.dp)
                .padding(start = 64.dp, end = 64.dp, top = 8.dp, bottom = 8.dp)
                .border(
                    1.dp,
                    Color(android.graphics.Color.parseColor("#006064")),
                    RoundedCornerShape(50)
                )
                .onFocusChanged { focusState ->
                    if (focusState.isFocused) {
                        isPasswordTouched = true
                        if (password == "Contraseña") {
                            password = ""
                        }
                    } else {
                        if (password.isBlank()) {
                            isPasswordTouched = false
                        }
                    }
                },

            singleLine = true,
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                color = Color(android.graphics.Color.parseColor("#006064")),
                fontSize = 14.sp
            ),
            shape = RoundedCornerShape(50.dp),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(android.graphics.Color.parseColor("#006064")),
                cursorColor = Color(android.graphics.Color.parseColor("#006064")),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )

        TextField(

            value = if(isConfPasswordTouched) confPassword else "Confirma la Contraseña",
            onValueChange = { text ->
                isConfPasswordTouched = true
                confPassword = text
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(66.dp)
                .padding(start = 64.dp, end = 64.dp, top = 8.dp, bottom = 8.dp)
                .border(
                    1.dp,
                    Color(android.graphics.Color.parseColor("#006064")),
                    RoundedCornerShape(50)
                )
                .onFocusChanged { focusState ->
                    if (focusState.isFocused) {
                        isConfPasswordTouched = true
                        if (confPassword == "Confirma la Contraseña") {
                            confPassword = ""
                        }
                    } else {
                        if (confPassword.isBlank()) {
                            isConfPasswordTouched = false
                        }
                    }
                },

            singleLine = true,
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                color = Color(android.graphics.Color.parseColor("#006064")),
                fontSize = 14.sp
            ),
            shape = RoundedCornerShape(50.dp),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(android.graphics.Color.parseColor("#006064")),
                cursorColor = Color(android.graphics.Color.parseColor("#006064")),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )



    }

}
