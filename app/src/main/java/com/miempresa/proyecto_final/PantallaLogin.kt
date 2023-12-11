package com.miempresa.proyecto_final

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

class PantallaLogin: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)


    fun loginconEmailyContrasena(email: String, password:String, context: Context, home: ()->   Unit)
            = viewModelScope.launch {
        try {
            auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {authResult->
                    Log.d("FB", "" +
                            "Ingreso Correcto: ${authResult.toString()}")
                    home()
                }
                .addOnFailureListener{ex->
                    Toast.makeText(
                        context,
                        "Credenciales incorrectas, intente nuevamente",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.d("FB", "" +
                            "Ingreso Incorrecto: ${ex.localizedMessage}")
                    //errorLogueo()
                }
        }
        catch (ex:Exception){
            Log.d("proyecto_final", "Ingreso: ${ex.message}")
        }
    }

    fun crearNuevosUsuarios(
        email:String,
        password: String,
        home: () -> Unit
    ){
        if (_loading.value == false){
            _loading.value = true
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task->
                    if (task.isSuccessful){
                        home()
                    }
                    else{
                        Log.d("proyecto_final", "Registro: ${task.result.toString()}")
                    }
                    _loading.value = false
                }
        }
    }
}