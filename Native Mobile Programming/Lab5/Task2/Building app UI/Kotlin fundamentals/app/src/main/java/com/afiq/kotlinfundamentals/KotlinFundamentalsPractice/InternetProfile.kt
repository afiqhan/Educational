package com.afiq.kotlinfundamentals.KotlinFundamentalsPractice

fun main(){
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}
class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        // Fill in code
        val hobby = when (this.hobby){
            null -> "Doesn't have hobby."
            else ->{
                "Likes to $hobby."
            }
        }
        val referrer  = when (this.referrer){
            null -> "Doesn't have referrer."
            else ->{
                "Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}."
            }
        }
        println("Name: ${this.name}\nAge: ${this.age}\n$hobby $referrer\n")
    }
}