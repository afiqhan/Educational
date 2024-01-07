package com.afiq.conditionalstatements.task1

fun main(args: Array<String>) {

    // 1
    println("1\n-------------------")
    var trafficLightColor = "Black" // change to var so that you can reuse it

    if (trafficLightColor == "Red") {
        println("Stop")
    } else if (trafficLightColor == "Yellow") {
        println("Slow")
    } else if (trafficLightColor == "Green") {
        println("Go")
    } else {
        println("Invalid traffic-light color")
    }
    // --------------------------------------------------------------
    // 2
    // Rewrite an if/else statement with a when statement(using when keyword)
    println("2\n-------------------")
    trafficLightColor = "Yellow"

    when (trafficLightColor) {
        "Red" -> println("Stop")
        "Yellow" -> println("Slow")
        "Green" -> println("Go")
        else -> println("Invalid traffic-light color")
    }

    // Write more complex conditions in a when statement
    val x = 3
    when (x) {
        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
        3 -> println("x is a prime number between 1 and 10.")
        5 -> println("x is a prime number between 1 and 10.")
        7 -> println("x is a prime number between 1 and 10.")
        else -> println("x isn't a prime number between 1 and 10.")
    }

    when (x) {
        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
        else -> println("x isn't a prime number between 1 and 10.")
    }

    //Use the in keyword for a range of conditions
    val y = 4
    when (y) {
        2, 3, 5, 7 -> println("y is a prime number between 1 and 10.")
        in 1..10 -> println("y is a number between 1 and 10, but not a prime number.")
        else -> println("y isn't a prime number between 1 and 10.")
    }

    //Use the is keyword to check data type
    val z: Any = 20
    when (z) {
        2, 3, 5, 7 -> println("z is a prime number between 1 and 10.")
        in 1..10 -> println("z is a number between 1 and 10, but not a prime number.")
        is Int -> println("z is an integer number, but not between 1 and 10.")
        else -> println("z isn't an integer number.")
    }
    // Try it
    trafficLightColor = "Amber"
    when (trafficLightColor) {
        "Red" -> println("Stop")
        "Yellow", "Amber" -> println("Slow")
        "Green" -> println("Go")
        else -> println("Invalid traffic-light color")
    }
    //-------------------------------------------------------------------------------
    //3
    //Convert an if statement to an expression
     trafficLightColor = "Black"

    val message =
        if (trafficLightColor == "Red") "Stop"
        else if (trafficLightColor == "Yellow") "Slow"
        else if (trafficLightColor == "Green") "Go"
        else "Invalid traffic-light color"

    println(message)

    // Try it
    trafficLightColor = "Amber"

    val newMessage = when(trafficLightColor) {
        "Red" -> "Stop"
        "Yellow", "Amber" -> "Slow"
        "Green" -> "Go"
        else -> "Invalid traffic-light color"
    }
    println(newMessage)
}