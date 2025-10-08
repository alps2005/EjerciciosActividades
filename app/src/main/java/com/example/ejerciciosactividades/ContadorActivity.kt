package com.example.ejerciciosactividades

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ContadorActivity : AppCompatActivity() {
    var cuenta: Int = 0
    lateinit var tvCuenta: TextView
    lateinit var btnContar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contador)
        tvCuenta = findViewById(R.id.tvCuenta)
        btnContar = findViewById(R.id.btnContar)
        btnContar.setOnClickListener {
            cuenta++
            tvCuenta.text = cuenta.toString()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}