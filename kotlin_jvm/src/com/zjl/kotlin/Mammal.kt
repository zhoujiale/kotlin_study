package com.zjl.kotlin

/**
 * @className Mammal
 * @descrption TODO
 * @date 2022/7/14 20:58
 * @author zhou
 */
sealed class Mammal (val name:String)

class Cat(val catName:String) : Mammal(catName)
class Human(val hummanName:String,val job:String): Mammal(hummanName)

fun greetMammal(mammal: Mammal): String{
    when (mammal){
        is Human -> return "Hello ${mammal.name}; You're working as a ${mammal.job}"
        is Cat -> return "Hello ${mammal.name}"
    }
}
fun main() {
    println(greetMammal(Cat("Snowy")))
}