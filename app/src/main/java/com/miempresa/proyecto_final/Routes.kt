package com.miempresa.proyecto_final

sealed class Routes(val route:String) {
    object StartScreen: Routes("startscreen")
    object LoginScreen: Routes("loginscreen")
    object PantallaRegistro: Routes("pantallaregistro")
    object PantallaDificultad: Routes("pantalladificultad")
    object PantallaResultados: Routes("pantallaresultados")
}