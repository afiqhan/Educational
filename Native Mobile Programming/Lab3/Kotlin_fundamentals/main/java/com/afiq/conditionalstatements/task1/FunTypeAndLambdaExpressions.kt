package com.afiq.conditionalstatements.task1

//Main method
//fun main(){
//    // 1: Store a function in a variable
//    val trickFunction = trick
//    trick()
//    trickFunction()
//    //2:Use functions as a data type
//    treat()
//}

// New Main method
fun main(){
    //2: Use functions as a data type
//    val coins: (Int) -> String = { quantity ->
//        "$quantity quarters"
//    }
    //3: Write lambda expressions with shorthand syntax
//    val coins: (Int)  -> String = {
//        "$it quarters"
//    }
//    val cupcake: (Int) -> String = {
//        "Have a cupcake!"
//    }
    //3: Write lambda expressions with shorthand syntax
    val treatFunction = trickOrTreat(false) { "$it quarters" }
    val trickFunction = trickOrTreat(true, null)
//    treatFunction()
    //4: Use the repeat() function
    repeat(4) {
        treatFunction()
    }
    trickFunction()
}

//2: Use functions as a data type
fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        if(extraTreat != null){
            println(extraTreat(5))
        }
        return treat
    }
}

// 1: Store a function in a variable
val trick =  {
    println("No treats!")
}

//2:Use functions as a data type
val treat: () -> Unit = {
    println("Have a treat!")
}