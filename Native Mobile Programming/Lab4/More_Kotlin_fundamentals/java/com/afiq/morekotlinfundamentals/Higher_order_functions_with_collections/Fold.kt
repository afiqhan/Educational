package com.afiq.morekotlinfundamentals.Higher_order_functions_with_collections

fun main(args: Array<String>) {
    val totalPrice = cookies.fold(0.0) {total, cookie ->
        total + cookie.price
    }
    println("Total price: $${totalPrice}")
}