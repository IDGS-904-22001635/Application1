package com.example.application1.TemasKotlin

fun main() {
    var num: Int

    do {
        println("Ingresar numero para hacer la piramide o presiona 0 para salir:")
        num = readLine()!!.toInt()

        for (i in 1..num) {
            println("*".repeat(i))
        }
    } while (num != 0)
}