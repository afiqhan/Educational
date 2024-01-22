package com.afiq.morekotlinfundamentals.Higher_order_functions_with_collections



fun main(args: Array<String>) {
    val fullMenu = cookies.map {
        "${it.name} - $${it.price}"
    }
    println("Full menu:")
    fullMenu.forEach {
        println(it)
    }
}