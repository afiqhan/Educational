package com.afiq.kotlinfundamentals.KotlinFundamentalsPractice

class Song  (
    private val title: String,
    private val artist: String,
    private val yearPublished: Int,
    private val playCount:Int
){
    fun isPopular():Boolean{
        if(this.playCount < 1000)
            return false
        return true
    }
    fun songDescription(){
        println("$title, performed by $artist, was released in $yearPublished.")
    }
}
fun main(){
    val firstSong = Song(title = "Without Me", artist = "Mr. Alomory", yearPublished = 1990, 2000000)
    firstSong.songDescription()
    println(firstSong.isPopular())
}
/*
Properties for the title, artist, year published, and play count
A property that indicates whether the song is popular. If the play count is less than 1,000, consider it unpopular.
A method that prints a song description in this format:
"[Title], performed by [artist], was released in [year published]."
* */