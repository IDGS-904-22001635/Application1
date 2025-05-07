package com.example.application1.TemasKotlin

/*
List
MutableList
Set
MutableSet
Map
MutableMap


val readOnlyFiguras = listOf("cuadrado","Triangulo","circulo")
println(readOnlyFiguras)


var figura = mutableListOf("cuadrado", "triangulo","circulo")
val readOnlyFiguras = listOf("cuadrado","triangulo","circulo")
val mutableFiguras : List<String>= figura


val frutas= setOf("manzana","banana","naranja")
var frutas= mutableSetOf("manzana","banana","naranja")

val coches =mapOf("Uno" to 1,"dos" to 2,"tres" to 3)
println(coches)
        val coches2 =mutableMapOf("Uno" to 1,"dos" to 2,"tres" to 3)
println(coches2)
 */

fun main() {
        // Lista de solo lectura (inmutable)
        val readOnlyFiguras = listOf("cuadrado", "triangulo", "circulo")

        // Acceso a elementos (corregido el nombre de la variable)
        println("La primera figura es ${readOnlyFiguras[0]}")
        println("El primer elemento es ${readOnlyFiguras.first()}")
        println("Número de elementos: ${readOnlyFiguras.count()} items")
        println("¿Existe 'circulo'? ${"circulo" in readOnlyFiguras}")
        println(readOnlyFiguras)

        // Lista mutable
        var figura: MutableList<String> = mutableListOf("cuadrado2", "triangulo2", "circulo2")
        println(figura)

        // Añadir elemento (correcto)
        figura.add("pentagono")
        println(figura)

        // Eliminar elemento (corregido nombre de variable y valor a eliminar)
        figura.remove("cuadrado2")  // Corregido de "cuadro2" a "cuadrado2"
}

