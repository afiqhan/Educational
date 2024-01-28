package com.afiq.morekotlinfundamentals.Generics_Objects_And_Extensions
/*
------------------------------------
Make a reusable class with generics
------------------------------------
*/
// Regular classes in Kotlin
class FillInTheBlankQuestion(
    val questionText: String,
    val answer: String,
    val difficulty: String
)

class TrueOrFalseQuestion(
    val questionText: String,
    val answer: Boolean,
    val difficulty: String
)
class NumericQuestion(
    val questionText: String,
    val answer: Int,
    val difficulty: String
)

//we can replace it with Generic Class
//class Question<T>(
//    val questionText: String,
//    val answer: T,
////    val difficulty: String
//    val difficulty: Difficulty
//)
/*
------------------------------------
Use an enum class
------------------------------------
*/
enum class Difficulty {
    EASY, MEDIUM, HARD
}
/*
------------------------------------
Use a data class
------------------------------------
*/
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)
/*------------------------------------
Use a singleton object
------------------------------------*/
object StudentProgress {
    var total: Int = 10
    var answered: Int = 3
}


class Quiz :ProgressPrintable {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

    //Rewrite extension functions using interfaces
    override val progressText: String
        get() = "${answered} of ${total} answered"
    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(progressText)
    }

    /*------------------------------------
    Extend classes with new properties and methods
    ------------------------------------*/
    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }

}
/*------------------------------------
Extend classes with new properties and methods
------------------------------------*/
//val Quiz.StudentProgress.progressText: String
//    get() = "${answered} of ${total} answered"

//Add an extension function
//fun Quiz.StudentProgress.printProgressBar() {
//    repeat(Quiz.answered) { print("▓") }
//    repeat(Quiz.total - Quiz.answered) { print("▒") }
//    println()
//    println(Quiz.progressText)
//}

/*------------------------------------
Rewrite extension functions using interfaces
------------------------------------*/
interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

// Main Function
fun main(args: Array<String>) {
//    val question1 = Question<String>("Quoth the raven ___", "nevermore", "medium")
//    val question2 = Question<Boolean>("The sky is green. True or false", false, "easy")
//    val question3 = Question<Int>("How many days are there between full moons?", 28, "hard")
    // there is no output, just testing

    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    println("Using Generics and Enum with data Keyword\n${question1.toString()}")
    //output: Question(questionText=Quoth the raven ___, answer=nevermore, difficulty=MEDIUM)

    println("\nAccess a singleton object\n${StudentProgress.answered} of ${StudentProgress.total} answered.")
    println("${Quiz.answered} of ${Quiz.total} answered.")

    //println("\nExtend classes with new properties and methods\n${Quiz.progressText}")
    println("\nProgressBar")
    //Quiz.printProgressBar()
    Quiz().printProgressBar()

    println("\nUse scope functions to access class properties and methods")
    val quiz = Quiz()
    quiz.printQuiz()
    println("\nCall an object's methods without a variable using apply()")
    Quiz().apply {
        printQuiz()
    }
}