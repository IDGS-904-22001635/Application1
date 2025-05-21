package com.example.application1.TemasKotlin

class usuarios(){
    val materia:String=""
}
class usuarios2(val id:Int, val nombre: String){
    val materia: String= ""
    fun hola(){
        println("Hola Humano")
        println("Hola $nombre")
    }
}
fun main(){
    val alumno = usuarios()
    val alumno2=usuarios2(1,"Carlos")

    println(alumno2.id)
    println(alumno2.nombre)
    alumno2.hola()
}