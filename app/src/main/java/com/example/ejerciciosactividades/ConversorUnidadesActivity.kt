package com.example.ejerciciosactividades

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConversorUnidadesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_conversor_unidades)
        var edtCantidad: EditText = findViewById(R.id.edtCantidad)
        var btnCalcular: Button = findViewById(R.id.btnCalcular)
        var tvRespuesta: TextView = findViewById(R.id.tvRespuesta)

        btnCalcular.setOnClickListener {
            if (edtCantidad.text.toString() != ""){
                var cantidad = edtCantidad.text.toString().toDouble()
                cantidad = cantidad * 2.2;
                tvRespuesta.text = cantidad.toString()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}