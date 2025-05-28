package com.example.application1.tema3App

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.application1.R

class Ejemplo3Activity : AppCompatActivity() {
    private lateinit var editext: EditText
    private var num=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo4)
        editext=findViewById(R.id.ed1)
        num=(Math.random()*1000).toInt()
        var cadena=num.toString()
        val notification= Toast.makeText(this,cadena, Toast.LENGTH_LONG)
        notification.show()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun controlar(view:android.view.View){
        val valorIngresado: String=editext.text.toString()
        val valor=valorIngresado.toInt()
        if(valor==num){
            val notification= Toast.makeText(this,"Correcto", Toast.LENGTH_LONG)
            notification.show()
        }else{
            val notification= Toast.makeText(this,"Incorrecto", Toast.LENGTH_LONG)
            notification.show()
        }
    }
}