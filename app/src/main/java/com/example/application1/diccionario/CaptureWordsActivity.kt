package com.example.application1.diccionario

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.application1.R
import java.io.FileOutputStream
import java.io.OutputStreamWriter

class CaptureWordsActivity : AppCompatActivity() {
    private lateinit var etIngles: EditText
    private lateinit var etEspanol: EditText
    private lateinit var btnGuardar: Button
    private lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_capture_words)
        etIngles = findViewById(R.id.etIngles)
        etEspanol = findViewById(R.id.etEspanol)
        btnGuardar = findViewById(R.id.btnGuardar)
        btnRegresar = findViewById(R.id.btnRegresar)
        btnGuardar.setOnClickListener {
            guardarPalabra()
        }
        var btnRegresar = findViewById<Button>(R.id.btnRegresar)
        btnRegresar.setOnClickListener {
            finish()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
        fun toast(mensaje: String) {
            android.widget.Toast.makeText(this, mensaje, android.widget.Toast.LENGTH_SHORT).show()
        }
        fun guardarPalabra() {
            var ingles = etIngles.text.toString().trim()
            var espanol = etEspanol.text.toString().trim()

            if (ingles.isEmpty() || espanol.isEmpty()) {
                toast("Debes de ingresar las dos palabras")
                return
            }

            try {
                FileOutputStream(filesDir.path + "/diccionario.txt", true).use { fos ->
                    OutputStreamWriter(fos).use { osw ->
                        osw.write("$ingles:$espanol\n")
                    }
                }

                AlertDialog.Builder(this)
                    .setTitle("Éxito")
                    .setMessage("Palabras guardadas correctamente")
                    .setPositiveButton("Aceptar", null)
                    .show()

                etIngles.text.clear()
                etEspanol.text.clear()
            } catch (e: Exception) {
                toast("Error al guardar las palabras")
                e.printStackTrace()
            }
        }
    }