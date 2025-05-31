package com.example.application1.diccionario

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.application1.R
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

class SearchWordActivity : AppCompatActivity() {
    private lateinit var etPalabraBuscar: EditText
    private lateinit var rbIngles: RadioButton
    private lateinit var tvResultado: TextView
    private lateinit var btnBuscarPalabra: Button
    private lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search_word)
        etPalabraBuscar = findViewById(R.id.etPalabraBuscar)
        rbIngles = findViewById(R.id.rbIngles)
        tvResultado = findViewById(R.id.tvResultado)
        btnBuscarPalabra = findViewById(R.id.btnBuscarPalabra)
        btnRegresar = findViewById(R.id.btnRegresar)

        btnBuscarPalabra.setOnClickListener {
            buscarPalabra()
        }

        btnRegresar.setOnClickListener {
            finish()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun buscarPalabra() {
        val palabra = etPalabraBuscar.text.toString().trim()
        val buscarEnIngles = rbIngles.isChecked

        if (palabra.isEmpty()) {
            toast("Ingresa una palabra")
            return
        }

        try {
            FileInputStream(filesDir.path + "/diccionario.txt").use { fis ->
                BufferedReader(InputStreamReader(fis)).use { br ->
                    var linea: String?
                    var encontrada = false

                    while (br.readLine().also { linea = it } != null) {
                        linea?.let {
                            val partes = it.split(":")
                            if (partes.size == 2) {
                                val ingles = partes[0].trim()
                                val espanol = partes[1].trim()

                                if (buscarEnIngles && ingles.equals(palabra, true)) {
                                    tvResultado.text = "Traducción: $espanol"
                                    encontrada = true
                                    return@use
                                } else if (!buscarEnIngles && espanol.equals(palabra, true)) {
                                    tvResultado.text = "Traducción: $ingles"
                                    encontrada = true
                                    return@use
                                }
                            }
                        }
                    }
                    if (!encontrada) {
                        tvResultado.text = "Palabra no hayada"
                    }
                }
            }
        } catch (e: Exception) {
            toast(" No tengo esa palabra")
            e.printStackTrace()
        }
    }
    private fun toast(mensaje: String) {
        android.widget.Toast.makeText(this, mensaje, android.widget.Toast.LENGTH_SHORT).show()
    }
}