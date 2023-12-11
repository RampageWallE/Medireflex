package com.miempresa.proyecto_final

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.miempresa.proyecto_final.ui.theme.Proyecto_finalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Proyecto_finalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController, startDestination = Routes.StartScreen.route
                    ) {
                        //DEFINICIÓN DE LAS RUTAS
                        composable(Routes.StartScreen.route) {
                            StartScreen(navController = navigationController)
                        }
                        composable(Routes.LoginScreen.route) {
                            LoginScreen(navController = navigationController)
                        }
                        composable(Routes.PantallaRegistro.route) {
                            PantallaRegistro(navController = navigationController)
                        }
                        composable(Routes.PantallaDificultad.route) {
                            PantallaDificultad(navController = navigationController)
                        }
                        composable(Routes.PantallaResultados.route) {
                            PantallaResultados(navController = navigationController)
                        }
                    }
                }
            }
        }
    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Proyecto_finalTheme {
    }
}