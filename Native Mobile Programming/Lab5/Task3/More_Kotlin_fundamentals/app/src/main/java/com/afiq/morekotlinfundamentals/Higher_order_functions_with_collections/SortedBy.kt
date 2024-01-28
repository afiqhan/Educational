package com.afiq.morekotlinfundamentals.Higher_order_functions_with_collections

fun main(args: Array<String>) {
    val alphabeticalMenu = cookies.sortedBy {
        it.name
    }
    println("Alphabetical menu:")
    alphabeticalMenu.forEach {
        println(it.name)
    }
}