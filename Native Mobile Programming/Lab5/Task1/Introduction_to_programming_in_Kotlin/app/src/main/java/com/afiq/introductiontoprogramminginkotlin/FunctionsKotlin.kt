package com.afiq.introductiontoprogramminginkotlin

//Main function in kotlin: the app start running from here
fun main(args: Array<String>){

    birthdayGreeting()// print nothing since we change the return type to string

    println(birthdayGreetingReturnString()) // printing out the value returned from the function

    println(birthdayGreeting("Omar"))// passing one value to args to return it with the result

    println(birthdayGreeting( "Omar",24))// more than one parameters passed to a function

    // Named args
    println(birthdayGreeting(name = "Omar", age = 24))
    println(birthdayGreeting(age = 24, name = "Omar"))

    // Default parameter
    println(birthdayGreetingDefaultArgs(age = 24))
    println(birthdayGreetingDefaultArgs(name = "Alnobi", age = 24))
}

// old function that return nothing
// Birthday greeting function
fun birthdayGreeting() : Unit{ // return nothing/ void type
    println("Happy Birthday, Rover!")
    println("You are now 5 years old!")
}

// function without parameters but return String
fun birthdayGreetingReturnString(): String {// return String type
    val nameGreeting = "Happy Birthday, Rover!"
    val ageGreeting = "You are now 5 years old!"
    return "$nameGreeting\n$ageGreeting"
}

// function with one parameter and return String
fun birthdayGreeting(name: String): String {
    val nameGreeting = "Happy Birthday, $name!"
    val ageGreeting = "You are now 5 years old!"
    return "$nameGreeting\n$ageGreeting"
}

// function with parameters(String, int) and return String
fun birthdayGreeting(name: String, age: Int): String {
    val nameGreeting = "Happy Birthday, $name!"
    val ageGreeting = "You are now $age years old!"
    return "$nameGreeting\n$ageGreeting"
}

// Default Args
fun birthdayGreetingDefaultArgs(name: String = "Omar", age: Int): String {
    return "Happy Birthday, $name! You are now $age years old!"
}