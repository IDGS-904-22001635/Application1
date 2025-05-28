package com.example.palindromo.logicaPalindromo

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.palindromo.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        val tvOriginal = findViewById<TextView>(R.id.tvOriginal)
        val tvReversed = findViewById<TextView>(R.id.tvReversed)
        val tvVowels = findViewById<TextView>(R.id.tvVowels)
        val tvConsonants = findViewById<TextView>(R.id.tvConsonants)

        val originalText = intent.getStringExtra("ORIGINAL_TEXT") ?: ""
        val reversedText = intent.getStringExtra("REVERSED_TEXT") ?: ""
        val vowels = intent.getIntExtra("VOWELS", 0)
        val consonants = intent.getIntExtra("CONSONANTS", 0)

        tvOriginal.text = "Original: $originalText"
        tvReversed.text = "Reverso: $reversedText"
        tvVowels.text = "Vocales: $vowels"
        tvConsonants.text = "Consonantes: $consonants"
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}