package com.example.application1.TemasKotlin

fun main(){
    val d: Int
    val check = true
    if(check) {
        d = 1
    } else{
        d=2
    }
    print(d)

    val d2 = if (check) 1 else 2
    print(d2)
    println("----------------------------------------------------------------")
    print("Ingrese el sueldo del empleado:")
    val sueldo = readln().toDouble()
    if (sueldo > 3000)
        println("Debe pagar mas impuestos")
}