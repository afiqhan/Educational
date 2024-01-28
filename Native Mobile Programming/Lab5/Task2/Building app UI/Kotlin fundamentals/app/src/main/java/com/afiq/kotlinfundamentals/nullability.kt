package com.afiq.kotlinfundamentals

fun main(args: Array<String>){
    //1: What is null?, where to use it
    var favoriteActors = null
    println(favoriteActors)

    //Understand non-nullable and nullable variables
    var favoriteActor: String? = "Sandra Oh"
    favoriteActor = null

    favoriteActor = "Sandra Oh"
    println(favoriteActor)

    favoriteActor = null
    println(favoriteActor)

    //Try it: Write a nullable Int value
    println("\nTry it: Write a nullable Int value")
    var number: Int? = 10
    println(number)

    number = null
    println(number)

    //----------------------------------------------------
    //2 Handle non-nullable variables
    println("\n2: Handle non-nullable variables")
    favoriteActor = "Sandra Oh"
    println(favoriteActor.length)

    // using safe call (?.) operator to call a method of non-nullable variable
    var myActor:String? = "Sandra Oh"
    println(myActor?.length)
    myActor = null
    println(myActor?.length)

    // Use the !! not-null assertion operator
    println("\nUse the !! not-null assertion operator")
    myActor = "Sandra Oh"
    println(myActor!!.length)

//    myActor = null
//    println(myActor!!.length)

    //Use the if/else conditionals with nullable variables
    println("\nUse the if/else conditionals with nullable variables")
    if (myActor != null) {
        println("The number of characters in your favorite actor's name is ${myActor.length}.")
    }else {
        println("You didn't input a name.")
    }
    // assigning nullable variable to another variable to check the length using if
    println("\nassigning nullable variable to another variable to check the length using if")
    var lengthOfName = if (myActor != null) {
        myActor.length
    } else {
        0
    }

    println("The number of characters in your favorite actor's name is $lengthOfName.")

    // Using Elvis operator instead of if statement
    println("\nUsing Elvis operator instead of if statement")
     lengthOfName = myActor?.length ?: 0

    println("The number of characters in your favorite actor's name is $lengthOfName.")

}