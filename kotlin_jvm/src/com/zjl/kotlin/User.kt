package com.zjl.kotlin

/**
 * @className User
 * @descrption TODO
 * @date 2022/7/14 20:26
 * @author zhou
 */
data class User(val name:String,val id:Int){
    override fun equals(other: Any?): Boolean {
        return other is User && other.id == this.id
    }
}

fun main() {
    val user = User("Tom",1)
    println(user)
    val secondUser = User("Alex",1)
    val thirdUser = User("Max",2)

    println("user == secondUser: ${user == secondUser}")   // 4
    println("user == thirdUser: ${user == thirdUser}")

    println(user.hashCode())                               // 5
    println(secondUser.hashCode())
    println(thirdUser.hashCode())

    println(user.copy())                                   // 6
    println(user == user.copy())                          // 7
    println(user.copy("Max"))                              // 8
    println(user.copy(id = 3))
}