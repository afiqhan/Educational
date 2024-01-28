package com.afiq.morekotlinfundamentals.PracticeClassesAndCollections

enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING,
}

data class Event2(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int,
)
fun main(args: Array<String>) {
    println(Event2(
        title="Study Kotlin",
        description="Commit to studying Kotlin at least 15 minutes per day.",
        daypart=Daypart.EVENING, durationInMinutes=15))
}