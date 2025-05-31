package com.example.application1.diccionario

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.application1.R
import android.content.Intent

class DiccionarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_diccionario)
        val btnAgregar=findViewById<Button>(R.id.goToCapture)
        val btnBuscar=findViewById<Button>(R.id.goToSearch)

        btnAgregar.setOnClickListener {
            startActivity(Intent(this, CaptureWordsActivity::class.java))
        }

        btnBuscar.setOnClickListener {
            startActivity(Intent(this, SearchWordActivity::class.java))
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}