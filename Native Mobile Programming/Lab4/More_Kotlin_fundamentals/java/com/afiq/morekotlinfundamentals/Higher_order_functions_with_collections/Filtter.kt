package com.afiq.morekotlinfundamentals.Higher_order_functions_with_collections

fun main(args: Array<String>) {
    val softBakedMenu = cookies.filter {
        it.softBaked
    }
    println("Soft cookies:")
    softBakedMenu.forEach {
        println("${it.name} - $${it.price}")
    }
}