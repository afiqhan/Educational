
//list
package com.afiq.morekotlinfundamentals.Use_collections_in_Kotlin

fun main(args: Array<String>) {
//    val solarSystem = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
//    println(solarSystem.size)
//    println(solarSystem[2])
//    println(solarSystem.get(3))
//    println(solarSystem.indexOf("Earth"))
//    println(solarSystem.indexOf("Pluto"))
//
//    //Iterate over list elements using a for loop
//    for (planet in solarSystem) {
//        println(planet)
//    }

    val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    solarSystem.add("Pluto")
    solarSystem[3] = "Future Moon"
    println(solarSystem[3])
    println(solarSystem[8])
    solarSystem.removeAt(8)
    solarSystem.remove("Future Moon")
    println(solarSystem.contains("Pluto"))
    println("Future Moon" in solarSystem)




}