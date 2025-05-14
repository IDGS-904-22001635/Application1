package com.example.application1.tema1App

import android.content.Intent
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

class Ejemplo1Activity : AppCompatActivity() {

    private var et1: EditText? = null
    private var et2: EditText? = null
    private var tv1: TextView? = null
    private var rb1: Button? = null
    private var rb2: Button? = null
    private var rb3: Button? = null
    private var rb4: Button? = null
    private var btnNext: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo1)
        // Initialize views by assigning to class properties
        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        tv1 = findViewById(R.id.tv1)
        rb1 = findViewById(R.id.rb1)
        rb2 = findViewById(R.id.rb2)
        rb3 = findViewById(R.id.rb3)
        rb4 = findViewById(R.id.rb4)
        btnNext = findViewById(R.id.btnNext)

        btnNext?.setOnClickListener {
            val intent = Intent(this, Ejemplo2Activity::class.java)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun sumar(view: View) {
        val valor1 = et1?.text?.toString()?.toDouble() ?: 0.0
        val valor2 = et2?.text?.toString()?.toDouble() ?: 0.0
        val resultado = valor1 + valor2
        tv1?.text = "Resultado: $resultado"
    }

    fun restar(view: View) {
        val valor1 = et1?.text?.toString()?.toDouble() ?: 0.0
        val valor2 = et2?.text?.toString()?.toDouble() ?: 0.0
        val resultado = valor1 - valor2
        tv1?.text = "Resultado: $resultado"
    }

    fun multiplicar(view: View) {
        val valor1 = et1?.text?.toString()?.toDouble() ?: 0.0
        val valor2 = et2?.text?.toString()?.toDouble() ?: 0.0
        val resultado = valor1 * valor2
        tv1?.text = "Resultado: $resultado"
    }

    fun dividir(view: View) {
        val valor1 = et1?.text?.toString()?.toDouble() ?: 0.0
        val valor2 = et2?.text?.toString()?.toDouble() ?: 0.0

        if (valor2 == 0.0) {
            tv1?.text = "Error: No se puede dividir entre cero"
        } else {
            val resultado = valor1 / valor2
            tv1?.text = "Resultado: $resultado"
        }
    }

}