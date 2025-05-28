package com.example.application1.tema4App

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.application1.R
import java.io.FileNotFoundException

class Ejemplo4ctivity : AppCompatActivity() {
    private val fileName = "Datos.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo4ctivity)

        val inputText = findViewById<EditText>(R.id.inputText)
        val outputText = findViewById<TextView>(R.id.outputText)
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)
        val btnGuardar = findViewById<Button>(R.id.saveButton)
        val btnLeer = findViewById<Button>(R.id.readButton)

        btnBorrar.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirmación")
            builder.setMessage("¿Estás seguro de que deseas borrar los datos?")

            builder.setPositiveButton("Sí") { _, _ ->
                try {
                    openFileOutput(fileName, MODE_PRIVATE).use { outputStream ->
                        outputStream.write("".toByteArray())
                    }
                    Toast.makeText(this, "Datos borrados", Toast.LENGTH_LONG).show()
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(this, "Error al borrar los datos: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }

            builder.setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
            }

            builder.show()
        }
        btnGuardar.setOnClickListener {
            val text =inputText.text.toString()+"\n"
            try {
                openFileOutput(fileName,MODE_APPEND).use{
                    it.write(text.toByteArray())
                }
                inputText.text.clear()
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
        btnLeer.setOnClickListener {
            try {
                val contenido = openFileInput(fileName).bufferedReader().use { reader ->
                    reader.readText()
                }
                outputText.text = contenido
            } catch (e: FileNotFoundException) {
                outputText.text = "No hay datos guardados"
                Toast.makeText(this, "Archivo no encontrado", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                e.printStackTrace()
                outputText.text = "Error al leer archivo"
                Toast.makeText(this, "Error: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}