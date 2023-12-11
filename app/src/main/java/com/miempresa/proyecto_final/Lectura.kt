package com.miempresa.proyecto_final

data class Lectura(
    val aciertos: Int? = 0,
    val fallos: Int? = 0,
    val porcentajeAciertos: Double? = 0.0,
    val tiempoReaccion: Int? = 0
)