package com.example.pictolingo.objects

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import coil.compose.AsyncImagePainter
import com.example.pictolingo.R
import com.example.pictolingo.ui.theme.amarillo
import com.example.pictolingo.ui.theme.amarillo_fuerte
import com.example.pictolingo.ui.theme.gris

data class Pictogram(
    val name: String,
    val picture: AsyncImagePainter,
    val color: Color,
)

data class PictogramPack(
    val name: String,
    val anagrams: List<Pictogram>,
    val color: Color,
    val picture: AsyncImagePainter,
    val index:Int,
)

@Composable
fun getPictogramPacks(): List<PictogramPack> {
    return listOf(
        PictogramPack(
            "Animales",
            listOf(
                Pictogram("Ardilla", intToAsync(R.drawable.ardilla), Color(0xFFB2C8E8)),
                Pictogram("Burro", intToAsync(R.drawable.burro), Color(0xFFB2C8E8)),
                Pictogram("Canguro", intToAsync(R.drawable.canguro), Color(0xFFB2C8E8)),
                Pictogram("Cerdo", intToAsync(R.drawable.cerdo), Color(0xFFB2C8E8)),
                Pictogram("Cucaracha", intToAsync(R.drawable.cucaracha), Color(0xFFB2C8E8)),
                Pictogram("Delfín", intToAsync(R.drawable.delfin), Color(0xFFB2C8E8)),
                Pictogram("Gato", intToAsync(R.drawable.gato), Color(0xFFB2C8E8)),
                Pictogram("Hipopótamo", intToAsync(R.drawable.hipopotamo), Color(0xFFB2C8E8)),
                Pictogram("Ladrar", intToAsync(R.drawable.ladrar), Color(0xFFB2C8E8)),
                Pictogram("Mapache", intToAsync(R.drawable.mapache), Color(0xFFB2C8E8)),
                Pictogram("Pato", intToAsync(R.drawable.patito), Color(0xFFB2C8E8)),
                Pictogram("Pingüino", intToAsync(R.drawable.pinguino), Color(0xFFB2C8E8)),
                Pictogram("Ratón", intToAsync(R.drawable.raton), Color(0xFFB2C8E8)),
                Pictogram("Vaca", intToAsync(R.drawable.vaca), Color(0xFFB2C8E8)),
                Pictogram("Zarigüeya", intToAsync(R.drawable.tlacuache), Color(0xFFB2C8E8)),
                Pictogram("Zorro", intToAsync(R.drawable.zorra), Color(0xFFB2C8E8))
            ), Color(0xFFB2C8E8), intToAsync(R.drawable.animales),0),
        PictogramPack(
            "Dinero",
            listOf(
                Pictogram("Alcancía", intToAsync(R.drawable.alcancia), Color(0xFFB2C8E8)),
                Pictogram("Banco", intToAsync(R.drawable.banco), Color(0xFFB2C8E8)),
                Pictogram("Caja", intToAsync(R.drawable.caja), Color(0xFFB2C8E8)),
                Pictogram("Cartera", intToAsync(R.drawable.cartera), Color(0xFFB2C8E8)),
                Pictogram("Cinco Pesos", intToAsync(R.drawable.cincop), Color(0xFFB2C8E8)),
                Pictogram("Cincuenta Centavos", intToAsync(R.drawable.cincuentac), Color(0xFFB2C8E8)),
                Pictogram("Cincuenta Pesos", intToAsync(R.drawable.cincuentap), Color(0xFFB2C8E8)),
                Pictogram("Comprar", intToAsync(R.drawable.comprar), Color(0xFFB2C8E8)),
                Pictogram("Diez Centavos", intToAsync(R.drawable.diezc), Color(0xFFB2C8E8)),
                Pictogram("Dólar", intToAsync(R.drawable.dolar), Color(0xFFB2C8E8)),
                Pictogram("Dos Pesos", intToAsync(R.drawable.dosp), Color(0xFFB2C8E8)),
                Pictogram("Monedas ", intToAsync(R.drawable.monedas), Color(0xFFB2C8E8)),
                Pictogram("Monedero ", intToAsync(R.drawable.monedero), Color(0xFFB2C8E8)),
                Pictogram("Necesito Cambio ", intToAsync(R.drawable.necesitocambio), Color(0xFFB2C8E8)),
                Pictogram("Precio ", intToAsync(R.drawable.precio), Color(0xFFB2C8E8)),
                Pictogram("Recibo ", intToAsync(R.drawable.recibo), Color(0xFFB2C8E8)),
                Pictogram("Un Peso ", intToAsync(R.drawable.unp), Color(0xFFB2C8E8)),
                Pictogram("Veinte Pesos ", intToAsync(R.drawable.veintep), Color(0xFFB2C8E8))
            ), Color(0xFFB2C8E8), intToAsync(R.drawable.dineroo),1),
        PictogramPack(
            "Constructores de Oraciones",
            listOf(
                Pictogram("Abajo", intToAsync(R.drawable.abajo), Color(0xFFB2C8E8)),
                Pictogram("A través de", intToAsync(R.drawable.a_traves_de), Color(0xFFB2C8E8)),
                Pictogram("Al lado de", intToAsync(R.drawable.al_lado_de), Color(0xFFB2C8E8)),
                Pictogram("Alrededor", intToAsync(R.drawable.alrededor), Color(0xFFB2C8E8)),
                Pictogram("Arriba", intToAsync(R.drawable.arriba), Color(0xFFB2C8E8)),
                Pictogram("Atrás", intToAsync(R.drawable.atras), Color(0xFFB2C8E8)),
                Pictogram("¿Cómo?", intToAsync(R.drawable.como), Color(0xFFB2C8E8)),
                Pictogram("¿Cuánto es?", intToAsync(R.drawable.cuanto_es), Color(0xFFB2C8E8)),
                Pictogram("¿Cuántos hay?", intToAsync(R.drawable.cuantos_hay), Color(0xFFB2C8E8)),
                Pictogram("De", intToAsync(R.drawable.de), Color(0xFFB2C8E8)),
                Pictogram("Dentro", intToAsync(R.drawable.dentro), Color(0xFFB2C8E8)),
                Pictogram("El", intToAsync(R.drawable.el), Color(0xFFB2C8E8)),
                Pictogram("En Frente", intToAsync(R.drawable.en_frente), Color(0xFFB2C8E8)),
                Pictogram("En Medio", intToAsync(R.drawable.en_medio), Color(0xFFB2C8E8)),
                Pictogram("Eso", intToAsync(R.drawable.eso), Color(0xFFB2C8E8)),
                Pictogram("Esos", intToAsync(R.drawable.esos), Color(0xFFB2C8E8)),
                Pictogram("Esto", intToAsync(R.drawable.estos), Color(0xFFB2C8E8)),
                Pictogram("Estos", intToAsync(R.drawable.estos), Color(0xFFB2C8E8)),
                Pictogram("Fuera", intToAsync(R.drawable.fuera), Color(0xFFB2C8E8)),
                Pictogram("Sobre", intToAsync(R.drawable.sobre), Color(0xFFB2C8E8)),
                Pictogram("Y", intToAsync(R.drawable.y), Color(0xFFB2C8E8))
            ), gris, intToAsync(R.drawable.oracionesss),2),
        PictogramPack(
            "Transporte",
            listOf(
                Pictogram("Accidente", intToAsync(R.drawable.accidente), Color(0xFFB2C8E8)),
                Pictogram("Aeropuerto", intToAsync(R.drawable.aeropuerto), Color(0xFFB2C8E8)),
                Pictogram("Ambulancia", intToAsync(R.drawable.ambulancia), Color(0xFFB2C8E8)),
                Pictogram("Asegurar", intToAsync(R.drawable.asegurar), Color(0xFFB2C8E8)),
                Pictogram("Auto", intToAsync(R.drawable.auto), Color(0xFFB2C8E8)),
                Pictogram("Autobus", intToAsync(R.drawable.autobus), Color(0xFFB2C8E8)),
                Pictogram("Avión", intToAsync(R.drawable.avion), Color(0xFFB2C8E8)),
                Pictogram("Barco", intToAsync(R.drawable.barco), Color(0xFFB2C8E8)),
                Pictogram("Bicicleta", intToAsync(R.drawable.bici), Color(0xFFB2C8E8)),
                Pictogram("Camión de basura", intToAsync(R.drawable.basura), Color(0xFFB2C8E8)),
                Pictogram("Camión de Bomberos", intToAsync(R.drawable.bomberos), Color(0xFFB2C8E8)),
                Pictogram("Calle", intToAsync(R.drawable.calle), Color(0xFFB2C8E8)),
                Pictogram("Camión", intToAsync(R.drawable.camion), Color(0xFFB2C8E8)),
                Pictogram("Cerrar Puerta", intToAsync(R.drawable.cerrar_coche), Color(0xFFB2C8E8)),
                Pictogram("Cerrar con llave", intToAsync(R.drawable.cerrar_llave), Color(0xFFB2C8E8)),
                Pictogram("Cinturón", intToAsync(R.drawable.cinturon), Color(0xFFB2C8E8)),
                Pictogram("Cohete", intToAsync(R.drawable.cohete), Color(0xFFB2C8E8)),
                Pictogram("Estacionar", intToAsync(R.drawable.estacionar), Color(0xFFB2C8E8)),
                Pictogram("Gasolinera", intToAsync(R.drawable.gasolinera), Color(0xFFB2C8E8)),
                Pictogram("Helicóptero", intToAsync(R.drawable.helicoptero), Color(0xFFB2C8E8)),
                Pictogram("Ir", intToAsync(R.drawable.ir), Color(0xFFB2C8E8)),
                Pictogram("Ir rápido", intToAsync(R.drawable.ir_rapido), Color(0xFFB2C8E8)),
                Pictogram("Jet", intToAsync(R.drawable.jet), Color(0xFFB2C8E8)),
                Pictogram("Licencia", intToAsync(R.drawable.licencia), Color(0xFFB2C8E8)),
                Pictogram("Limpiaparabrisas", intToAsync(R.drawable.limpiaparabrisas), Color(0xFFB2C8E8)),
                Pictogram("Llanta", intToAsync(R.drawable.llanta), Color(0xFFB2C8E8)),
                Pictogram("Llaves", intToAsync(R.drawable.llaves), Color(0xFFB2C8E8)),
                Pictogram("Manejar", intToAsync(R.drawable.manejar), Color(0xFFB2C8E8)),
                Pictogram("Mapa", intToAsync(R.drawable.mapa), Color(0xFFB2C8E8)),
                Pictogram("Metro", intToAsync(R.drawable.metro), Color(0xFFB2C8E8)),
                Pictogram("Motocicleta", intToAsync(R.drawable.motocicleta), Color(0xFFB2C8E8)),
                Pictogram("Motor", intToAsync(R.drawable.motor), Color(0xFFB2C8E8)),
                Pictogram("Norte", intToAsync(R.drawable.norte), Color(0xFFB2C8E8)),
                Pictogram("Oeste", intToAsync(R.drawable.oeste), Color(0xFFB2C8E8)),
                Pictogram("Parar", intToAsync(R.drawable.parar), Color(0xFFB2C8E8)),
                Pictogram("Patineta", intToAsync(R.drawable.patineta), Color(0xFFB2C8E8)),
                Pictogram("Patrulla", intToAsync(R.drawable.patrulla), Color(0xFFB2C8E8)),
                Pictogram("Ponchado", intToAsync(R.drawable.ponchado), Color(0xFFB2C8E8)),
                Pictogram("Puente", intToAsync(R.drawable.puente), Color(0xFFB2C8E8)),
                Pictogram("Puerta de bus", intToAsync(R.drawable.puerta_bus), Color(0xFFB2C8E8)),
                Pictogram("Silla de ruedas", intToAsync(R.drawable.sillaruedas), Color(0xFFB2C8E8)),
                Pictogram("Tractor", intToAsync(R.drawable.tractor), Color(0xFFB2C8E8)),
                Pictogram("Tren", intToAsync(R.drawable.tren), Color(0xFFB2C8E8)),
                Pictogram("Troca", intToAsync(R.drawable.troca), Color(0xFFB2C8E8)),
                Pictogram("Túnel", intToAsync(R.drawable.tunel), Color(0xFFB2C8E8)),
                Pictogram("Van", intToAsync(R.drawable.van), Color(0xFFB2C8E8))
            ), amarillo, intToAsync(R.drawable.transpo),3),
        PictogramPack(
            "Transporte",
            listOf(
                Pictogram("Accidente", intToAsync(R.drawable.accidente), Color(0xFFB2C8E8)),
                Pictogram("Aeropuerto", intToAsync(R.drawable.aeropuerto), Color(0xFFB2C8E8)),
                Pictogram("Ambulancia", intToAsync(R.drawable.ambulancia), Color(0xFFB2C8E8)),
                Pictogram("Asegurar", intToAsync(R.drawable.asegurar), Color(0xFFB2C8E8)),
                Pictogram("Auto", intToAsync(R.drawable.auto), Color(0xFFB2C8E8)),
                Pictogram("Autobus", intToAsync(R.drawable.autobus), Color(0xFFB2C8E8)),
                Pictogram("Avión", intToAsync(R.drawable.avion), Color(0xFFB2C8E8)),
                Pictogram("Barco", intToAsync(R.drawable.barco), Color(0xFFB2C8E8)),
                Pictogram("Bicicleta", intToAsync(R.drawable.bici), Color(0xFFB2C8E8)),
                Pictogram("Camión de basura", intToAsync(R.drawable.basura), Color(0xFFB2C8E8)),
                Pictogram("Camión de Bomberos", intToAsync(R.drawable.bomberos), Color(0xFFB2C8E8)),
                Pictogram("Calle", intToAsync(R.drawable.calle), Color(0xFFB2C8E8)),
                Pictogram("Camión", intToAsync(R.drawable.camion), Color(0xFFB2C8E8)),
                Pictogram("Cerrar Puerta", intToAsync(R.drawable.cerrar_coche), Color(0xFFB2C8E8)),
                Pictogram("Cerrar con llave", intToAsync(R.drawable.cerrar_llave), Color(0xFFB2C8E8)),
                Pictogram("Cinturón", intToAsync(R.drawable.cinturon), Color(0xFFB2C8E8)),
                Pictogram("Cohete", intToAsync(R.drawable.cohete), Color(0xFFB2C8E8)),
                Pictogram("Estacionar", intToAsync(R.drawable.estacionar), Color(0xFFB2C8E8)),
                Pictogram("Gasolinera", intToAsync(R.drawable.gasolinera), Color(0xFFB2C8E8)),
                Pictogram("Helicóptero", intToAsync(R.drawable.helicoptero), Color(0xFFB2C8E8)),
                Pictogram("Ir", intToAsync(R.drawable.ir), Color(0xFFB2C8E8)),
                Pictogram("Ir rápido", intToAsync(R.drawable.ir_rapido), Color(0xFFB2C8E8)),
                Pictogram("Jet", intToAsync(R.drawable.jet), Color(0xFFB2C8E8)),
                Pictogram("Licencia", intToAsync(R.drawable.licencia), Color(0xFFB2C8E8)),
                Pictogram("Limpiaparabrisas", intToAsync(R.drawable.limpiaparabrisas), Color(0xFFB2C8E8)),
                Pictogram("Llanta", intToAsync(R.drawable.llanta), Color(0xFFB2C8E8)),
                Pictogram("Llaves", intToAsync(R.drawable.llaves), Color(0xFFB2C8E8)),
                Pictogram("Manejar", intToAsync(R.drawable.manejar), Color(0xFFB2C8E8)),
                Pictogram("Mapa", intToAsync(R.drawable.mapa), Color(0xFFB2C8E8)),
                Pictogram("Metro", intToAsync(R.drawable.metro), Color(0xFFB2C8E8)),
                Pictogram("Motocicleta", intToAsync(R.drawable.motocicleta), Color(0xFFB2C8E8)),
                Pictogram("Motor", intToAsync(R.drawable.motor), Color(0xFFB2C8E8)),
                Pictogram("Norte", intToAsync(R.drawable.norte), Color(0xFFB2C8E8)),
                Pictogram("Oeste", intToAsync(R.drawable.oeste), Color(0xFFB2C8E8)),
                Pictogram("Parar", intToAsync(R.drawable.parar), Color(0xFFB2C8E8)),
                Pictogram("Patineta", intToAsync(R.drawable.patineta), Color(0xFFB2C8E8)),
                Pictogram("Patrulla", intToAsync(R.drawable.patrulla), Color(0xFFB2C8E8)),
                Pictogram("Ponchado", intToAsync(R.drawable.ponchado), Color(0xFFB2C8E8)),
                Pictogram("Puente", intToAsync(R.drawable.puente), Color(0xFFB2C8E8)),
                Pictogram("Puerta de bus", intToAsync(R.drawable.puerta_bus), Color(0xFFB2C8E8)),
                Pictogram("Silla de ruedas", intToAsync(R.drawable.sillaruedas), Color(0xFFB2C8E8)),
                Pictogram("Tractor", intToAsync(R.drawable.tractor), Color(0xFFB2C8E8)),
                Pictogram("Tren", intToAsync(R.drawable.tren), Color(0xFFB2C8E8)),
                Pictogram("Troca", intToAsync(R.drawable.troca), Color(0xFFB2C8E8)),
                Pictogram("Túnel", intToAsync(R.drawable.tunel), Color(0xFFB2C8E8)),
                Pictogram("Van", intToAsync(R.drawable.van), Color(0xFFB2C8E8))
            ), amarillo_fuerte, intToAsync(R.drawable.transpo),4),




    )
}