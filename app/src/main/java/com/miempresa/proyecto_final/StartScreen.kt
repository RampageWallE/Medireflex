package com.miempresa.proyecto_final

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun StartScreen(navController: NavHostController){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Column(modifier = Modifier
            .align(Alignment.Center)
            .padding(30.dp)
            .fillMaxWidth()) {
            Imagen()
            Boton1(navController)
            Boton2(navController)

        }
    }
}

@Composable
fun Boton1(navController: NavHostController) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { navController.navigate(Routes.LoginScreen.route) }
        ) {
            Text(text = "Inicio",
                fontSize = 20.sp)
        }
    }
}

@Composable
fun Boton2(navController: NavHostController) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { navController.navigate(Routes.PantallaRegistro.route) }
        ) {
            Text(text = "Registrarse",
                fontSize = 20.sp)
        }
    }
}

@Composable
fun Imagen() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(50.dp),
        horizontalArrangement = Arrangement.Center) {
        Image(
            modifier = Modifier.width(500.dp),
            painter = painterResource(id = R.drawable.iconmedireflex),
            contentScale = ContentScale.FillWidth,
            contentDescription = "Logo")
    }
}