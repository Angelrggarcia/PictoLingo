package com.example.pictolingo.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pictolingo.ui.theme.hueso
import java.nio.file.WatchEvent
import com.example.pictolingo.ui.theme.md_theme_light_onPrimaryContainer
import com.example.pictolingo.ui.theme.blaco
import com.example.pictolingo.ui.theme.md_theme_light_onPrimaryContainer
import com.example.pictolingo.ui.theme.otro_blaco
@Composable
// se encarga de generar la funcion para mandar codigos y traer el perfil
fun CargarPerfil(){

    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    Column {
        Box(
            // estructura de la box
            modifier = Modifier
                .padding(8.dp)
                .background(color = otro_blaco)
                .border(width = 4.dp, color = hueso, shape = RoundedCornerShape(40.dp) )
                .fillMaxWidth(),
                //.aspectRatio(1f)
                //.clip(RoundedCornerShape(40.dp))
            contentAlignment = Alignment.TopCenter
        ){
            Text(
                text = "Introduce el codigo del perfil que desea cargar.",
                color = md_theme_light_onPrimaryContainer,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )

        }

    }
}
