package com.example.ejerciciosactividades

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FormularioRegistroActivity : AppCompatActivity() {
    lateinit var edtNombre: EditText;
    lateinit var edtCorreo: EditText;
    lateinit var edtContra: EditText;
    lateinit var btnRegistrar: Button;
    lateinit var preferences: SharedPreferences; //shared preference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_formulario_registro)

        preferences = getSharedPreferences("registro", Context.MODE_PRIVATE)

        edtNombre = findViewById(R.id.edtNombre)
        edtCorreo = findViewById(R.id.edtCorreo)
        edtContra = findViewById(R.id.edtContra)
        btnRegistrar = findViewById(R.id.btnRegistrar)

        btnRegistrar.setOnClickListener {
            var editor = preferences.edit()
            editor.putString("nombre", edtNombre.text.toString())
            editor.putString("correo", edtCorreo.text.toString())
            editor.putString("contra", edtContra.text.toString())
            editor.commit()
            Toast.makeText(this, "Datos guardados con exito", Toast.LENGTH_LONG).show()
        }

        mostrarDatos()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun mostrarDatos(){
        edtNombre.setText(preferences.getString("nombre", ""))
        edtCorreo.setText(preferences.getString("correo", ""))
        edtContra.setText(preferences.getString("contra", ""))
    }
}