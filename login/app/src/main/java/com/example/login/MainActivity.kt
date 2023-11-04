package com.example.login

import androidx.compose.ui.text.font.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.ui.theme.LoginTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationGraph()
                }
            }
        }
    }
}
@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun login(navController: NavController= rememberNavController()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
            painter = painterResource(id = R.drawable.children),
            contentDescription = null,
            modifier = Modifier
                .height(220.dp)
                .graphicsLayer {
                    scaleX = 1.5f
                    scaleY = 1.5f
                }
        )
        Text("Bienvendio a Pictolingo",
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            color = Color(android.graphics.Color.parseColor("#006064")),

        )

        var username by remember { mutableStateOf("Username") }
        var password by remember { mutableStateOf("Contraseña") }
        var passwordVisible by rememberSaveable { mutableStateOf(false) }
        var isPasswordTouched by remember { mutableStateOf(false) }
        var isUsernameTouched by remember { mutableStateOf(false) }


        TextField(

            value = if(isUsernameTouched) username else "Username",
            onValueChange = { text ->
                isUsernameTouched = true
                username = text
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
                        isUsernameTouched = true
                        if (username == "Username") {
                            username = ""
                        }
                    } else {
                        if (username.isBlank()) {
                            isUsernameTouched = false
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
            placeholder = { Text("Username", color = Color.Gray) },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(android.graphics.Color.parseColor("#006064")),
                cursorColor = Color(android.graphics.Color.parseColor("#006064")),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )

        TextField(
            value = password,
            onValueChange = { text ->
                password = text },
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
            visualTransformation = if (
                passwordVisible) VisualTransformation.None
            else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(android.graphics.Color.parseColor("#006064")),
                cursorColor = Color(android.graphics.Color.parseColor("#006064")),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )


        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .height(66.dp)
                .padding(
                    start = 64.dp,
                    end = 64.dp,
                    top = 8.dp,
                    bottom = 8.dp
                ),
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(android.graphics.Color.parseColor("#006064"))

        )
        )
        {
            Text("Login",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

        }
        Text("¿Olvidaste la contraseña?",
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .clickable(onClick = {
                    println("si jala")
                }) ,
            fontSize = 14.sp,
            color = Color(android.graphics.Color.parseColor("#006064"))
        )
        Text("¿Eres nuevo? Crea una cuenta aquí",
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .clickable(onClick = {
                    navController.navigate(Routes.SignUpRoute)
                }) ,
            fontSize = 14.sp,
            color = Color(android.graphics.Color.parseColor("#006064"))
        )
        Image(
            painter = painterResource(id = R.drawable.acuarela),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer {
                    translationY = 150f
                    translationX = 150f
                    rotationZ = -22f
                    scaleX = -1.5f
                    scaleY = -1.5f
                },
            contentScale = ContentScale.FillBounds
        )


    }
}
@Composable
fun NavigationGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.MainRoute) {
        composable(Routes.MainRoute) {
            login(navController)
        }
        composable(Routes.SignUpRoute) {
            SignupScreen(navController)
        }
    }
}




