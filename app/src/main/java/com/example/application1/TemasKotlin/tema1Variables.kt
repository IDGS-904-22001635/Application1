package com.example.application1.TemasKotlin

fun main(){
    // variables solo lectura val
    // variables mutables var

    var a = 4
    var b = 8
    var c = 10
    println(a)
    println("el numero de b es $b")
    println("el numero de c +2 es ${c+2}")
    c= a + 2
    c += 8
    c -= 5
    c*8
    c/=2
    println("el valor de c es $c")

    val num1:Int=23
    val num2:Int=12

    val num3=6
    val nombre:String="Puga"
    var caracter:Char='a'
    //Le ponemos f por que si no marca error
    var num4:Float=12.5f
    var num5:Double=12.5
}