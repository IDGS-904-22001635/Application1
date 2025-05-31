package com.example.palindromo.logicaPalindromo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.application1.R

class PalindromoActivity : AppCompatActivity() {
    private lateinit var etInput: EditText
    private lateinit var btnCheck: Button
    private lateinit var tvResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_palindromo)
        etInput = findViewById(R.id.etInput)
        btnCheck = findViewById(R.id.btnCheck)
        tvResult = findViewById(R.id.tvResult)

        btnCheck.setOnClickListener {
            val inputText = etInput.text.toString().trim()

            if (inputText.isEmpty()) {
                Toast.makeText(this, "Por favor ingrese un texto", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (isPalindrome(inputText)) {
                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("ORIGINAL_TEXT", inputText)
                    putExtra("REVERSED_TEXT", inputText.reversed())
                    putExtra("VOWELS", countVowels(inputText))
                    putExtra("CONSONANTS", countConsonants(inputText))
                }
                startActivity(intent)
            } else {
                tvResult.text = "'$inputText' no es un palíndromo"
                tvResult.visibility = TextView.VISIBLE
            }
        }
    }

    private fun isPalindrome(text: String): Boolean {
        val cleanText = text.replace("\\s+".toRegex(), "").lowercase()
        return cleanText == cleanText.reversed()
    }

    private fun countVowels(text: String): Int {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        return text.lowercase().count { it in vowels }
    }

    private fun countConsonants(text: String): Int {
        val consonants = ('a'..'z').toSet() - setOf('a', 'e', 'i', 'o', 'u')
        return text.lowercase().count { it in consonants }
    }

}