package com.example.ejerciciosactividades

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.itemId
        if (id == R.id.menu_contador){
            startActivity(Intent(this, ContadorActivity::class.java))
        }else if (id == R.id.menu_conversor){
            startActivity(Intent(this, ConversorUnidadesActivity::class.java))
        }else{
            startActivity(Intent(this, FormularioRegistroActivity::class.java))
        }

        return super.onOptionsItemSelected(item)
    }

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