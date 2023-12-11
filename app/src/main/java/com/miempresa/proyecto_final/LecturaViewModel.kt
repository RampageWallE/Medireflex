package com.miempresa.proyecto_final

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

//FUNCION QUE MUESTRA LOS DATOS DE LAS LECTURAS EN TIEMPO REAL
class LecturaViewModel : ViewModel() {

    // Obtiene el ID del usuario actualmente autenticado con Firebase que se usara para obtener su propio registro de lecturas
    private var uid = FirebaseAuth.getInstance().currentUser?.uid

    // Etiqueta para identificar mensajes de registro (logs)
    private val TAG = "LecturaViewModel"

    // Referencia a la base de datos en tiempo real de Firebase específica para la lectura del usuario actual
    private val lecturaReference: DatabaseReference = FirebaseDatabase.getInstance().getReference("${uid}/lectura")

    // Estado mutable que representa la lectura actual
    private val _lectura = mutableStateOf(Lectura())

    // Propiedad de solo lectura para acceder al estado de lectura
    val lectura: Lectura get() = _lectura.value

    // Inicializador, donde se configura un listener para cambios en la referencia de lectura
    init {
        // Definición del listener que maneja los cambios en los datos
        val lecturaListener = object : ValueEventListener {
            // Se llama cuando los datos en la base de datos cambian
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Obtiene los datos de la base de datos y los convierte a un objeto de tipo Lectura
                val lecturaData = dataSnapshot.getValue(Lectura::class.java)
                // Asigna el valor al estado mutable (_lectura)
                _lectura.value = lecturaData ?: Lectura() // Si es nulo, utiliza un valor predeterminado.
            }
            // Se llama cuando la operación es cancelada, por ejemplo, debido a un error de red
            override fun onCancelled(databaseError: DatabaseError) {
                // Registra un mensaje de advertencia en caso de error
                Log.w(TAG, "loadLectura:onCancelled", databaseError.toException())
            }
        }
        // Agrega el listener a la referencia de la base de datos
        lecturaReference.addValueEventListener(lecturaListener)
    }
}