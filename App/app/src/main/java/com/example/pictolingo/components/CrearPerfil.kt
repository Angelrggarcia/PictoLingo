    @file:Suppress("DEPRECATION")

    package com.example.pictolingo.components
    import android.content.ContentValues.TAG
    import android.content.Context
    import android.util.Log
    import android.widget.Toast
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
    import androidx.compose.runtime.mutableIntStateOf
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.platform.LocalContext
    import androidx.compose.ui.platform.LocalView
    import androidx.compose.ui.text.input.KeyboardType
    import androidx.compose.ui.text.input.PasswordVisualTransformation
    import androidx.compose.ui.text.style.TextAlign
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import com.android.volley.toolbox.JsonArrayRequest
    import com.android.volley.toolbox.JsonObjectRequest
    import com.android.volley.toolbox.Volley
    import com.example.pictolingo.ui.theme.azul_verdoso
    import com.example.pictolingo.ui.theme.blaco
    import com.example.pictolingo.ui.theme.gris
    import com.example.pictolingo.ui.theme.hueso
    import com.example.pictolingo.ui.theme.md_theme_light_onPrimaryContainer
    import com.example.pictolingo.ui.theme.otro_blaco
    import org.json.JSONObject
    import kotlin.random.Random

    @Composable
    fun CrearPerfil( onCreatePerfil : () -> Unit ){

        var screen by remember { mutableIntStateOf(1) }

        when(screen) {
            1 -> {Login { screen = 2 } }
            2 -> {Perfil{ onCreatePerfil() }}
        }

    }

    fun iniciarSesion(context: Context, email: String, password: String, callback: (Boolean) -> Unit) {
        val queue = Volley.newRequestQueue(context)
        val url = "https://api-dev-crtb.1.us-1.fl0.io/api/user/login"

        val jsonObject = JSONObject()
        jsonObject.put("email", email)
        jsonObject.put("password", password)

        val jsonObjectRequest = JsonObjectRequest(
            url, jsonObject,
            { response ->
                Log.i(TAG, "Response is $response")
                Toast.makeText(context, "Inicio de sesion Completado", Toast.LENGTH_LONG).show()
                callback(true)
            },
            { error ->
                error.printStackTrace()
                Toast.makeText(context, "Hubo algun problema con su inicio de sesion", Toast.LENGTH_LONG).show()
                callback(false)
            }
        )

        queue.add(jsonObjectRequest)
    }








    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Login(onScreenChange : () -> Unit) {
        val appContext = LocalContext.current.applicationContext


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
                    text = "Correo: ",
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
                    onClick = {
                        if (usuario.isNotEmpty() && contrasena.isNotEmpty()) {
                            iniciarSesion(appContext, usuario, contrasena) { loginSuccessful ->
                                if (loginSuccessful) {
                                    onScreenChange() // Navigate to next screen on success
                                } else {
                                    // Handle login failure
                                }
                            }
                        } else {
                            // Handle empty fields
                        }
                    },
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


    fun generateRandomNumber(): String {
        return (1..10).joinToString("") { Random.nextInt(0, 10).toString() }
    }




    fun recivirJsonArray(context: Context) {

        val queue = Volley.newRequestQueue(context)
        val url = "https://api-dev-crtb.1.us-1.fl0.io/api/user"

        val jsonArrayRequest = JsonArrayRequest(
            url,
            { response ->
                Log.i(TAG, "Response is $response")
            },
            { error ->
                error.printStackTrace()

            }
        )

        queue.add(jsonArrayRequest)
    }

    fun enviarDatos(context: Context, nombre: String, edad:String, codigo:String){

        val queue = Volley.newRequestQueue(context)
        val url = "https://api-dev-crtb.1.us-1.fl0.io/api/user/signup"

        val jsonObject = JSONObject()

        jsonObject.put("edad",edad)
        jsonObject.put("code",codigo)
        jsonObject.put("name",nombre)
        jsonObject.put("password","default")

        val jsonObjectRequest = JsonObjectRequest(
            url, jsonObject,
            { response ->
                Log.i(TAG, "Response is $response")
            },
            { error ->
                error.printStackTrace()

            }
        )

        queue.add(jsonObjectRequest)
    }



    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Perfil(onCreatePerfil : () -> Unit) {

        val appContext = LocalContext.current.applicationContext
        LocalView.current

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
                    onClick = { onCreatePerfil()
                        enviarDatos(appContext,nombre,edad,codigo)
                        Toast.makeText(appContext, "$nombre agregado a la base de datos", Toast.LENGTH_LONG).show()
                              },
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
