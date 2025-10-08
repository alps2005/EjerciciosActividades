package com.example.ejerciciosactividades

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnAbrirContador).setOnClickListener {
            startActivity(Intent(this, ContadorActivity::class.java))
        }
        findViewById<Button>(R.id.btnCoversorUnidades).setOnClickListener {
            startActivity(Intent(this, ConversorUnidadesActivity::class.java))
        }
        findViewById<Button>(R.id.btnFormularioRegistro).setOnClickListener {
            startActivity(Intent(this, FormularioRegistroActivity::class.java))
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}