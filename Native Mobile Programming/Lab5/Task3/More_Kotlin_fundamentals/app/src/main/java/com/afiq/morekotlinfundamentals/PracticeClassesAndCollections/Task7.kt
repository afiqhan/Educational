package com.afiq.morekotlinfundamentals.PracticeClassesAndCollections


data class Event3(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int,

)
val Event3.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }

fun main(args: Array<String>) {
    val event1 = Event3(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0)
    val event2 = Event3(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15)
    val event3 = Event3(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30)
    val event4 = Event3(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60)
    val event5 = Event3(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10)
    val event6 = Event3(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)
    val events = mutableListOf<Event3>(event1, event2, event3, event4, event5, event6)


    val durationOfEvent = if (events[0].durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }
    println("Duration of first event of the day: $durationOfEvent")
}