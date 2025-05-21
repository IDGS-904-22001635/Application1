package com.example.application1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.application1.tema1App.Ejemplo1Activity
import com.example.application1.tema1App.Ejemplo2Activity
import com.example.application1.tema2App.activity_ejemplo2

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        val btnEjemplo1 =findViewById<Button>(R.id.btn1)
        val btnEjemplo2 =findViewById<Button>(R.id.btn2)
        val btnEjemplo3 =findViewById<Button>(R.id.btn3)

        btnEjemplo1.setOnClickListener { navegateToEjemplo() }
        btnEjemplo2.setOnClickListener { navegateToEjemplo2() }
        btnEjemplo3.setOnClickListener { navegateToEjemplo3() }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun navegateToEjemplo(){
        val intent = Intent(this, Ejemplo1Activity::class.java)
        startActivity(intent)
    }
    private fun navegateToEjemplo2(){
        val intent = Intent(this, Ejemplo2Activity::class.java)
        startActivity(intent)
    }
    private fun navegateToEjemplo3(){
        val intent = Intent(this, activity_ejemplo2::class.java)
        startActivity(intent)
    }
}