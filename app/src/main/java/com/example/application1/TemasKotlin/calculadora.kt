package com.example.application1.TemasKotlin

fun main() {
    var opcion: Int

    do {
        println("Calculadora Basica")
        println("Opciones:")
        println("1. Sumar")
        println("2. Restar")
        println("3. Multiplicar")
        println("4. Dividir")
        println("5. Salir")

        opcion = readLine()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> {
                print("Número 1: ")
                val a = readLine()?.toDoubleOrNull() ?: 0.0
                print("Número 2: ")
                val b = readLine()?.toDoubleOrNull() ?: 0.0
                sumar(a, b)
            }
            2 -> {
                print("Número 1: ")
                val a = readLine()?.toDoubleOrNull() ?: 0.0
                print("Número 2: ")
                val b = readLine()?.toDoubleOrNull() ?: 0.0
                restar(a, b)
            }
            3 -> {
                print("Número 1: ")
                val a = readLine()?.toDoubleOrNull() ?: 0.0
                print("Número 2: ")
                val b = readLine()?.toDoubleOrNull() ?: 0.0
                multiplicar(a, b)
            }
            4 -> {
                print("Número 1: ")
                val a = readLine()?.toDoubleOrNull() ?: 0.0
                print("Número 2: ")
                val b = readLine()?.toDoubleOrNull() ?: 0.0
                dividir(a, b)
            }
            5 -> println("Adiós")
            else -> println("Opción no válida")
        }
    } while (opcion != 5)
}

fun sumar(a: Double, b: Double) {
    println("La suma es $a + $b = ${a + b}")
}

fun restar(a: Double, b: Double) {
    println("La resta es$a - $b = ${a - b}")
}

fun multiplicar(a: Double, b: Double) {
    println("La multiplicacion es $a X $b = ${a * b}")
}

fun dividir(a: Double, b: Double) {

    if (b == 0.0) {
        println("Acuerdate que el divisor de la division no debe ser 0")
        print("!Pongase pilas!")
    } else {
        println("$a / $b = ${a.toDouble() / b}")
    }
}