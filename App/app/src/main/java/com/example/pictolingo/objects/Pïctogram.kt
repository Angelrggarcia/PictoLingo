package com.example.pictolingo.objects

import com.example.pictolingo.R

data class Pictogram(
    val name: String,
    val picture: Int,
)

data class PictogramPack(
    val name: String,
    val anagrams: List<Pictogram>,
    val color: String,
    val picture: Int,
    // More valueeeees... maybe?
)

fun getPictogramPacks(): List<PictogramPack> {
    return listOf(
        PictogramPack(
            "Animales",
            listOf(
                Pictogram("Ardilla", R.drawable.ardilla),
                Pictogram("Burro", R.drawable.burro),
                Pictogram("Canguro", R.drawable.canguro),
                Pictogram("Cerdo", R.drawable.cerdo),
                Pictogram("Cucaracha", R.drawable.cucaracha),
                Pictogram("Delfín", R.drawable.delfin),
                Pictogram("Gato", R.drawable.gato),
                Pictogram("Hipopótamo", R.drawable.hipopotamo),
                Pictogram("Ladrar", R.drawable.ladrar),
                Pictogram("Mapache", R.drawable.mapache),
                Pictogram("Pato", R.drawable.patito),
                Pictogram("Pingüino", R.drawable.pinguino),
                Pictogram("Ratón", R.drawable.raton),
                Pictogram("Vaca", R.drawable.vaca),
                Pictogram("Zarigüeya", R.drawable.tlacuache),
                Pictogram("Zorra", R.drawable.zorra)
            ), "Azul", R.drawable.animalesss
        ),
        PictogramPack(
            "Computadora",
            listOf(
                Pictogram("Bocinas", R.drawable.bocinas),
                Pictogram("Computadora", R.drawable.computadora),
                Pictogram("Cursor", R.drawable.cursor),
                Pictogram("Impresora", R.drawable.impresora),
                Pictogram("Mouse", R.drawable.mouse),
                Pictogram("Teclado", R.drawable.teclado),


            ), "Verde", R.drawable.compimag
        ),
        PictogramPack(
            "Dinero",
            listOf(
                Pictogram("Alcancía", R.drawable.alcancia),
                Pictogram("Banco", R.drawable.banco),
                Pictogram("Caja", R.drawable.caja),
                Pictogram("Cartera", R.drawable.cartera),
                Pictogram("Cinco Pesos", R.drawable.cincop),
                Pictogram("Cincuenta Centavos", R.drawable.cincuentac),
                Pictogram("Cincuenta Pesos", R.drawable.cincuentap),
                Pictogram("Comprar", R.drawable.comprar),
                Pictogram("Diez Centavos", R.drawable.diezc),
                Pictogram("Dólar", R.drawable.dolar),
                Pictogram("Dos Pesos", R.drawable.dosp),
                Pictogram("Monedas ", R.drawable.monedas),
                Pictogram("Monedero ", R.drawable.monedero),
                Pictogram("Necesito Cambio ", R.drawable.necesitocambio),
                Pictogram("Precio ", R.drawable.precio),
                Pictogram("Recibo ", R.drawable.recibo),
                Pictogram("Un Peso ", R.drawable.unp),
                Pictogram("Veinte Pesos ", R.drawable.veintep)
                ), "Rojo", R.drawable.dineroo
        ),
        PictogramPack(
            "Constructores \nde oraciones",
            listOf(
                Pictogram("Abajo", R.drawable.abajo),
                Pictogram("A través de", R.drawable.a_traves_de),
                Pictogram("Al lado de", R.drawable.al_lado_de),
                Pictogram("Alrededor", R.drawable.alrededor),
                Pictogram("Arriba", R.drawable.arriba),
                Pictogram("Atrás", R.drawable.atras),
                Pictogram("¿Cómo?", R.drawable.como),
                Pictogram("¿Cuánto es?", R.drawable.cuanto_es),
                Pictogram("¿Cuánto es?", R.drawable.cuantos_hay),
                Pictogram("De", R.drawable.de),
                Pictogram("Dentro", R.drawable.dentro),
                Pictogram("El", R.drawable.el),
                Pictogram("En Frente ", R.drawable.en_frente),
                Pictogram("En Medio ", R.drawable.en_medio),
                Pictogram("Eso ", R.drawable.eso),
                Pictogram("Esos ", R.drawable.esos),
                Pictogram("Esto ", R.drawable.esto),
                Pictogram("Estos ", R.drawable.estos),
                Pictogram("Fuera ", R.drawable.fuera),
                Pictogram("Sobre ", R.drawable.sobre),
                Pictogram("Y ", R.drawable.y)

            ), "Negro", R.drawable.oracionesss
        ),
        PictogramPack(
            "Transporte",
            listOf(
                Pictogram("Accidente", R.drawable.accidente),
                Pictogram("Aeropuerto", R.drawable.aeropuerto),
                Pictogram("Ambulancia", R.drawable.ambulancia),
                Pictogram("Asegurar", R.drawable.asegurar),
                Pictogram("Auto", R.drawable.auto),
                Pictogram("Autobus", R.drawable.autobus),
                Pictogram("Avión", R.drawable.avion),
                Pictogram("Barco", R.drawable.barco),
                Pictogram("Bicicleta", R.drawable.bici),
                Pictogram("Camión de basura", R.drawable.basura),
                Pictogram("Camión de Bomberos", R.drawable.bomberos),
                Pictogram("Calle", R.drawable.calle),
                Pictogram("Camión ", R.drawable.camion),
                Pictogram("Cerrar Puerta ", R.drawable.cerrar_coche),
                Pictogram("Cerrar con llave ", R.drawable.cerrar_llave),
                Pictogram("Cinturón ", R.drawable.cinturon),
                Pictogram("Cohete ", R.drawable.cohete),
                Pictogram("Estacioanr ", R.drawable.estacionar),
                Pictogram("Gasolinera ", R.drawable.gasolinera),
                Pictogram("Helicóptero ", R.drawable.helicoptero),
                Pictogram("Ir", R.drawable.ir),
                Pictogram("Ir rápido", R.drawable.ir_rapido),
                Pictogram("Jet", R.drawable.jet),
                Pictogram("Licencia", R.drawable.licencia),
                Pictogram("Limpiaparabrisas", R.drawable.limpiaparabrisas),
                Pictogram("Llanta", R.drawable.llanta),
                Pictogram("Llaves", R.drawable.llaves),
                Pictogram("Manejar", R.drawable.manejar),
                Pictogram("Mapa", R.drawable.mapa),
                Pictogram("Metro", R.drawable.metro),
                Pictogram("Motocicleta", R.drawable.motocicleta),
                Pictogram("Motor", R.drawable.motor),
                Pictogram("Norte", R.drawable.norte),
                Pictogram("Oeste", R.drawable.oeste),
                Pictogram("Parar", R.drawable.parar),
                Pictogram("Patineta", R.drawable.patineta),
                Pictogram("Patrulla", R.drawable.patrulla),
                Pictogram("Ponchado", R.drawable.ponchado),
                Pictogram("Puente", R.drawable.puente),
                Pictogram("Puerta de bus", R.drawable.puerta_bus),
                Pictogram("Silla de ruedas", R.drawable.sillaruedas),
                Pictogram("Tractor", R.drawable.tractor),
                Pictogram("Tren", R.drawable.tren),
                Pictogram("Troca", R.drawable.troca),
                Pictogram("Túnel", R.drawable.tunel),
                Pictogram("Van", R.drawable.van)
            ), "Naranja", R.drawable.transpo
        ),
        PictogramPack(
            "Clima",
            listOf(
                Pictogram("Caliente", R.drawable.caliente),
                Pictogram("Copo", R.drawable.copo),
                Pictogram("Derretirse", R.drawable.derretirse),
                Pictogram("Frío", R.drawable.frio),
                Pictogram("Helado", R.drawable.helado),
                Pictogram("Hielo", R.drawable.hielo),
                Pictogram("Invierno", R.drawable.invierno),
                Pictogram("Llover", R.drawable.llover),
                Pictogram("Lluvioso", R.drawable.lluvioso),
                Pictogram("Mojado", R.drawable.mojado),
                Pictogram("Neblina ", R.drawable.neblina),
                Pictogram("Nublado ", R.drawable.nublado),
                Pictogram("Parcialmente Nublado ", R.drawable.parcial_nublado),
                Pictogram("Soleado ", R.drawable.soleado),
                Pictogram("Temperatura ", R.drawable.temperatura),
                Pictogram("Ventoso ", R.drawable.ventoso),
                Pictogram("Verano", R.drawable.verano)
            ), "Rosa", R.drawable.climaa
        ),
        PictogramPack(
            "Lenguaje de Señas",
            listOf(
                Pictogram("Abrir", R.drawable.abrir),
                Pictogram("Adiós", R.drawable.adios),
                Pictogram("Ahí", R.drawable.ahi),
                Pictogram("Apuntar", R.drawable.apuntar),
                Pictogram("Aquí", R.drawable.aqui),
                Pictogram("Bienvenido", R.drawable.bienvenido),
                Pictogram("Comprender", R.drawable.comprender),
                Pictogram("Despacio", R.drawable.despacio),
                Pictogram("Después", R.drawable.despues),
                Pictogram("Domingo", R.drawable.domingo),
                Pictogram("Gracias ", R.drawable.gracias),
                Pictogram("Hacer ", R.drawable.hacer),
                Pictogram("Jueves", R.drawable.jueves),
                Pictogram("Jugar ", R.drawable.jugar),
                Pictogram("Lenguaje manual ", R.drawable.lenguaje_manual),
                Pictogram("Lunes ", R.drawable.lunes),
                Pictogram("Martes", R.drawable.martes),
                Pictogram("Más ", R.drawable.mas),
                Pictogram("Miércoles ", R.drawable.miercoles),
                Pictogram("Necesitar ", R.drawable.necesitar),
                Pictogram("Poner ", R.drawable.poner),
                Pictogram("Por favor ", R.drawable.porfavor),
                Pictogram("Probar ", R.drawable.probar),
                Pictogram("¿Qué es eso? ", R.drawable.que_es_eso),
                Pictogram("Rápido ", R.drawable.rapido),
                Pictogram("Sábado ", R.drawable.sabado),
                Pictogram("Tal vez ", R.drawable.tal_vez),
                Pictogram("Terminado ", R.drawable.terminado),
                Pictogram("Terminar ", R.drawable.terminar),
                Pictogram("Todo listo ", R.drawable.todo_listo),
                Pictogram("Trabajar ", R.drawable.trabajar),
                Pictogram("Venir ", R.drawable.venir),
                Pictogram("Viernes ", R.drawable.viernes),
                ), "Morado", R.drawable.lsm
        ),
    )



}