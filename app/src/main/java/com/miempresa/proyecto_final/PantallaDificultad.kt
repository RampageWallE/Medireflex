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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.database

//Se obtiene el UID del usuario que inicio sesion
var uid = FirebaseAuth.getInstance().currentUser?.uid

//Obtener la referencia de la base de datos
val database = Firebase.database.getReference("$uid")

//Se crea un objeto que mofificara los valores de las lecturas a 0
var void = Lectura(0, 0, 0.0, 0)

//Se crea una instancia para aceder al nodo dificultad
val myRef = database.child("dificultad")

//Se crea una instancia para aceder al nodo lecctura
val myRef2 = database.child("lectura")

@Composable
fun PantallaDificultad(navController: NavHostController){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF88FFFF))) {
        Column(modifier = Modifier
            .align(Alignment.Center)
            .padding(0.dp)
            .fillMaxWidth()) {
            Card(modifier = Modifier
                .padding(15.dp)
                .fillMaxHeight(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                    contentColor = Color.White),
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.outlinedCardElevation(defaultElevation = 20.dp)
            ){
                Column(modifier = Modifier
                    .padding(16.dp)
                    .background(Color.White)){
                    //ANIDAMIENTO DE OTRAS FUNCIONES COMPOSABLES
                    Bienvenida()
                    CerrarSesion(navController)
                    ImagenUsuario()
                    Seleccionar()
                    Dificultad1(navController)
                    Dificultad2(navController)
                    Dificultad3(navController)
                }
            }


        }
    }
}
@Composable
fun Bienvenida(){
    Text("Bienvenido, Usuario",
        modifier = Modifier
            .padding(5.dp),
        fontSize = 25.sp,
        color = Color.Black,
        fontWeight = FontWeight.Bold)
}

@Composable
fun ImagenUsuario() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.Center) {
        Image(
            modifier = Modifier.width(800.dp),
            painter = painterResource(id = R.drawable.usericon),
            contentScale = ContentScale.FillWidth,
            contentDescription = "Imagen usuario")
    }
}

@Composable
fun Seleccionar() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.Center) {
        Text(
            "Seleccione la dificultad",
            color = Color.Black,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Dificultad1(navController: NavHostController){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                //Se envia la dificultad y 0 en la lectura
                myRef.setValue(5000)
                myRef2.setValue(void)
                navController.navigate(Routes.PantallaResultados.route)
                      },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
        ) {
            Text(text = "Fácil",
                fontSize = 20.sp,
                color = Color.Black)
        }
    }
}

@Composable
fun Dificultad2(navController: NavHostController){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            //onClick = { navController.navigate(Routes.PantallaResultados.route) },
            onClick = {
                //Se envia la dificultad y 0 en la lectura
                myRef.setValue(3000)
                myRef2.setValue(void)
                navController.navigate(Routes.PantallaResultados.route)
                      },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
        ) {
            Text(text = "Normal",
                fontSize = 20.sp,
                color = Color.Black)
        }
    }
}

@Composable
fun Dificultad3(navController: NavHostController){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                //Se envia la dificultad y 0 en la lectura
                myRef.setValue(2000)
                myRef2.setValue(void)
                navController. navigate(Routes.PantallaResultados.route)
                      },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(text = "Dificil",
                fontSize = 20.sp,
                color = Color.Black)
        }
    }
}

@Composable
fun CerrarSesion(navController: NavHostController){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.Center
    ){
        Button(
            onClick = { navController.navigate(Routes.StartScreen.route) },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)){
            Text(text = "Cerrar sesion",
                fontSize = 25.sp,
                color = Color.Black
            )
        }
    }
}
