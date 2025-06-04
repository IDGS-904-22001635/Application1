package com.example.application1.resistencias

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.application1.R
import android.graphics.Color

class ResistenciasActivity : AppCompatActivity() {
    private val colorValues= mapOf(
        "Negro" to 0,
        "Cafe" to 1,
        "Rojo" to 2,
        "Naranja" to 3,
        "Amarillo" to 4,
        "Verde" to 5,
        "Azul" to 6,
        "Morado" to 7,
        "Gris" to 8,
        "Blanco" to 9
    )
    private val colores=listOf(
        "Negro", "Cafe", "Rojo", "Naranja", "Amarillo",
        "Verde", "Azul", "Morado", "Gris", "Blanco"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resistencias)
        setupDropdown(R.id.dropdown1)
        setupDropdown(R.id.dropdown2)
        setupDropdown(R.id.dropdown3)

        setupDropdownListener(R.id.dropdown1, R.id.colorView1, R.id.valorView1)
        setupDropdownListener(R.id.dropdown2, R.id.colorView2, R.id.valorView2)
        setupDropdownListener(R.id.dropdown3, R.id.colorView3, R.id.valorView3)


        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        btnCalcular.setOnClickListener {
            calcularResistencia()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
    private fun setupDropdown(dropdownId: Int) {
        val dropdown = findViewById<AutoCompleteTextView>(dropdownId)
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, colores)
        dropdown.setAdapter(adapter)
    }

    private fun calcularResistencia() {
        val dropdown1 = findViewById<AutoCompleteTextView>(R.id.dropdown1)
        val dropdown2 = findViewById<AutoCompleteTextView>(R.id.dropdown2)
        val dropdown3 = findViewById<AutoCompleteTextView>(R.id.dropdown3)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        val banda1View = findViewById<View>(R.id.banda1View)
        val banda2View = findViewById<View>(R.id.banda2View)
        val multView = findViewById<View>(R.id.multView)
        val toleranciaView = findViewById<View>(R.id.toleranciaView)

        if (dropdown1.text.isEmpty() || dropdown2.text.isEmpty() || dropdown3.text.isEmpty()) {
            Toast.makeText(this, "Selecciona todos los colores", Toast.LENGTH_SHORT).show()
            return
        }

        val selectedRadioId = radioGroup.checkedRadioButtonId
        if (selectedRadioId == -1) {
            Toast.makeText(this, "Selecciona una tolerancia", Toast.LENGTH_SHORT).show()
            return
        }

        val color1 = dropdown1.text.toString()
        val color2 = dropdown2.text.toString()
        val color3 = dropdown3.text.toString()

        val valor1 = colorValues[color1] ?: 0
        val valor2 = colorValues[color2] ?: 0
        val valor3 = colorValues[color3] ?: 0

        val valorBase = (valor1 * 10 + valor2) * Math.pow(10.0, valor3.toDouble())

        // Obtener tolerancia en valor decimal
        val toleranciaDecimal = when (selectedRadioId) {
            R.id.radioOro -> 0.05
            R.id.radioPlata -> 0.10
            else -> 0.0
        }

        val valorMinimo = valorBase * (1 - toleranciaDecimal)
        val valorMaximo = valorBase * (1 + toleranciaDecimal)

        val resultado = formatResistencia(valorBase)
        val resultadoMin = formatResistencia(valorMinimo)
        val resultadoMax = formatResistencia(valorMaximo)

        val toleranciaTexto = when (selectedRadioId) {
            R.id.radioOro -> " ±5%"
            R.id.radioPlata -> " ±10%"
            else -> ""
        }

        txtResultado.text = "Valor: $resultado$toleranciaTexto\nMínimo: $resultadoMin\nMáximo: $resultadoMax"

        banda1View.setBackgroundColor(obtenerColorHex(color1))
        banda2View.setBackgroundColor(obtenerColorHex(color2))
        multView.setBackgroundColor(obtenerColorHex(color3))

        val colorTolerancia = when (selectedRadioId) {
            R.id.radioOro -> "Dorado"
            R.id.radioPlata -> "Plateado"
            else -> ""
        }
        toleranciaView.setBackgroundColor(obtenerColorHex(colorTolerancia))
    }

    private fun obtenerColorHex(nombre: String): Int {
        return when (nombre) {
            "Negro" -> Color.BLACK
            "Cafe" -> Color.rgb(139, 69, 19)
            "Rojo" -> Color.RED
            "Naranja" -> Color.rgb(255, 165, 0)
            "Amarillo" -> Color.YELLOW
            "Verde" -> Color.GREEN
            "Azul" -> Color.BLUE
            "Morado" -> Color.rgb(148, 0, 211)
            "Gris" -> Color.GRAY
            "Blanco" -> Color.WHITE
            "Dorado" -> Color.rgb(212, 175, 55)
            "Plateado" -> Color.rgb(192, 192, 192)
            else -> Color.TRANSPARENT
        }
    }
    private fun setupDropdownListener(dropdownId: Int, colorViewId: Int, valorViewId: Int) {
        val dropdown = findViewById<AutoCompleteTextView>(dropdownId)
        val colorView = findViewById<View>(colorViewId)
        val valorView = findViewById<TextView>(valorViewId)

        dropdown.setOnItemClickListener { _, _, position, _ ->
            val colorNombre = colores[position]
            val valor = colorValues[colorNombre] ?: "-"
            colorView.setBackgroundColor(obtenerColorHex(colorNombre))
            valorView.text = valor.toString()
        }
    }
    private fun formatResistencia(valor: Double): String {
        return when {
            valor >= 1_000_000 -> "%.2f MΩ".format(valor / 1_000_000)
            valor >= 1_000 -> "%.2f kΩ".format(valor / 1_000)
            else -> "%.2f Ω".format(valor)
        }
    }

}