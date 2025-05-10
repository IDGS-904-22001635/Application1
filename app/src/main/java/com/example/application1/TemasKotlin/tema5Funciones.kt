package com.example.application1.TemasKotlin

fun saludo() {
    println("Hola Mundo")
}

fun suma(a: Int, b: Int) {
    println("La suma de $a + $b es ${a + b}")
}

fun resta(a: Int, b: Int): Int {
    return a - b
}

fun main() {
    saludo()
    suma(2, 3)  // Corrección: No se usan nombres de parámetros aquí
    println("La resta de 2 - 3 es ${resta(2, 3)}")  // Corrección: Sin nombres de parámetros
}