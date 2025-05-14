package com.example.application1.tema1App

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.application1.R

class Ejemplo2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo2)
        val etA = findViewById<EditText>(R.id.etA)
        val etB = findViewById<EditText>(R.id.etB)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)
        btnCalcular.setOnClickListener {
            val a = etA.text.toString().toDoubleOrNull() ?: 0.0
            val b = etB.text.toString().toDoubleOrNull() ?: 0.0
            var resultado = 0.0
            val proceso = StringBuilder()

            for (i in 1..b.toInt()) {
                resultado += a
                if (proceso.isNotEmpty()) proceso.append(" + ")
                proceso.append(a.toInt())
            }

            tvResultado.text = "${proceso} = ${resultado.toInt()}"
        }
        btnRegresar.setOnClickListener {
            finish() // este wey finaliza
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}