package com.example.application1.TemasKotlin
import kotlin.math.sqrt

fun main() {
    println("Resolución de ecuación cuadrática: ax² + bx + c = 0")
    println("(Solo muestra soluciones reales)")

    // Pa pedir los  coeficientes
    print("Ingrese a (diferente de cero): ")
    val a = readLine()?.toDoubleOrNull() ?: 0.0

    if (a == 0.0) {
        println("Error: 'a' no puede ser cero en una ecuación cuadrática")
        return
    }

    print("Ingrese b: ")
    val b = readLine()?.toDoubleOrNull() ?: 0.0

    print("Ingrese c: ")
    val c = readLine()?.toDoubleOrNull() ?: 0.0

    // Aqui calculamonn lo que es el descriminante
    val discriminante = b * b - 4 * a * c

    when {
        discriminante > 0 -> {
            // Dos soluciones reales diferentes
            val x1 = (-b + sqrt(discriminante)) / (2 * a)
            val x2 = (-b - sqrt(discriminante)) / (2 * a)
            println("\nSoluciones reales:")
            println("x₁ = ${"%.4f".format(x1)}")
            println("x₂ = ${"%.4f".format(x2)}")
        }
        discriminante == 0.0 -> {
            // Una solución real (raíz doble)
            val x = -b / (2 * a)
            println("\nSolución real única (raíz doble):")
            println("x = ${"%.4f".format(x)}")
        }
        else -> {
            // Discriminante negativo
            println("\nLa ecuación no tiene soluciones reales")
            println("(El discriminante es negativo: $discriminante)")
        }
    }
}