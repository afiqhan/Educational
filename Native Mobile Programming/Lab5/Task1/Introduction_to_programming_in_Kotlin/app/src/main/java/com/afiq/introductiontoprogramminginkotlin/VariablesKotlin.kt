package com.afiq.introductiontoprogramminginkotlin

fun main(args: Array<String>){
//    val count: Int = 10
//    println("You have $count unread messages.")
    val unreadCount = 5
    val readCount = 100
    println("You have ${unreadCount + readCount} total messages in your inbox.")

    val numberOfPhotos = 100
    val photosDeleted = 10
    println("$numberOfPhotos photos")
    println("$photosDeleted photos deleted")
    println("${numberOfPhotos - photosDeleted} photos left")


    //Update variables
    var cartTotal = 0
    println("Total: $cartTotal")

    cartTotal = 20
    println("Total: $cartTotal")

    var count = 10
    println("You have $count unread messages.")
    count--
    println("You have $count unread messages.")

    // explore other datatype

    val trip1 = 3.20
    val trip2 = 4.10
    val trip3 = 1.72
    val totalTripLength = trip1 + trip2 + trip3
    println("$totalTripLength miles left to destination")

    val nextMeeting = "Next meeting: "
    val date = "January 1"
    val reminder = nextMeeting + date
    println(reminder)


    println("Say \"hello\"")


    val notificationsEnabled: Boolean = false
    println("Are notifications enabled?  $notificationsEnabled")

    //commenting your code
    // This is a comment.
    var height = 1 // Assume the height is 1 to start with

    /*
     * This is a very long comment that can
     * take up multiple lines.
     */

    /**
     * This program displays the number of messages
     * in the user's inbox.
     */
    // Create a variable for the number of unread messages.

    println("You have $count unread messages.")

    // Decrease the number of messages by 1.
    count--
    println("You have $count unread messages.")
}