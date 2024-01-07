package com.afiq.conditionalstatements.task1.KotlinFundamentalsPractice

fun main() {
    // Fill in the code.
    printFinalTemperature(
        initialMeasurement = 27.0, initialUnit = "Celsius", finalUnit = "Fahrenheit"
    ) { "${(it) * 9 / 5 + 32}".toDouble() }
    printFinalTemperature(
        initialMeasurement = 350.0, initialUnit = "Kelvin", finalUnit = "Celsius"
    ) { "${(it) - 273.15}".toDouble() }
    printFinalTemperature(
        initialMeasurement = 10.0, initialUnit = "Fahrenheit", finalUnit = "Kelvin"
    ) { "${(it - 32) * 5 / 9  + 273.15 }".toDouble() }
/*
            27.0 degrees Celsius is 80.60 degrees Fahrenheit.
            350.0 degrees Kelvin is 76.85 degrees Celsius.
            10.0 degrees Fahrenheit is 260.93 degrees Kelvin.
*/


}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {

    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}