package com.example.application1

import android.R.attr.button
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Cinepolis : AppCompatActivity() {
    // Declarar los elementos de la vista
    private lateinit var txtName: EditText
    private lateinit var cantCompradores: EditText
    private lateinit var cantBoletos: EditText
    private lateinit var rbtSi: RadioButton
    private lateinit var boletosPagar: TextView
    private lateinit var btnCalcular: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cinepolis)
        txtName = findViewById(R.id.txtName)
        cantCompradores = findViewById(R.id.cant_compradores)
        cantBoletos = findViewById(R.id.cant_boletos)
        rbtSi = findViewById(R.id.rbtSi)
        boletosPagar = findViewById(R.id.boletos_pagar)
        btnCalcular = findViewById(R.id.btnCalcular)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnCalcular.setOnClickListener {
            calcularPago()
        }
    }

    private fun calcularPago() {
        val nombre = txtName.text.toString().trim()
        val strCompradores = cantCompradores.text.toString()
        val strBoletos = cantBoletos.text.toString()

        if (nombre.isEmpty() || strCompradores.isEmpty() || strBoletos.isEmpty()) {
            mostrarError("Por favor complete todos los campos")
            return
        }
//Validaciones
        try {
            val compradores = strCompradores.toInt()
            val boletos = strBoletos.toInt()

            if (compradores <= 0 || boletos <= 0) {
                mostrarError("Los valores deben ser mayores a cero")
                return
            }

            if (boletos > compradores * 7) {
                mostrarError("No se pueden comprar más de 7 boletos por persona")
                return
            }

            val total = calcularTotalConDescuentos(boletos)

            mostrarResultado(nombre, boletos, total)

        } catch (e: NumberFormatException) {
            mostrarError("Ingrese valores numéricos válidos")
        }
    }

    private fun calcularTotalConDescuentos(boletos: Int): Double {
        val precioUnitario = 12.00
        var total = boletos * precioUnitario

        total = when {
            boletos > 5 -> total * 0.85
            boletos in 3..5 -> total * 0.90
            else -> total
        }

        if (rbtSi.isChecked) {
            total *= 0.90
        }

        return total
    }

    private fun mostrarResultado(nombre: String, boletos: Int, total: Double) {
        val mensaje = """
            Cliente: $nombre
            Boletos comprados: $boletos
            Total a pagar: $${"%.2f".format(total)}
        """.trimIndent()

        boletosPagar.text = mensaje
    }

    private fun mostrarError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        boletosPagar.text = ""
    }
}