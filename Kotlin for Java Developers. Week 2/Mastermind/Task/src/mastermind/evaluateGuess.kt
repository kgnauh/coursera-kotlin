package mastermind

import kotlin.math.min

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var wrong = 0
    var right = 0
    var newSecret = ""
    var newGuess = ""

    val guessMap: MutableMap<Char, Int> = HashMap()
    val secretMap: MutableMap<Char, Int> = HashMap()

    for (i in secret.indices) {
        val guessLetter = guess[i]
        val secretLetter = secret[i]
        if (guessLetter == secretLetter)
            right += 1
        else {
            guessMap[guessLetter] = guessMap.getOrDefault(guessLetter,0) +1
            secretMap[secretLetter] = secretMap.getOrDefault(secretLetter, 0) +1
        }
    }

    for ((key) in guessMap)
    {
        if (key != null) {
            wrong += min(guessMap[key]!!, secretMap.getOrDefault(key, 0))
        }
    }


    /*
    for(c in guess) {
        val count = map[c]
            if (count != null && count > 0) {
                wrong++
                map[c] = count -1
        }
    }
    */
    /*
    val evaluatedChars = mutableListOf<Char>()

    for ( i in newSecret.indices) {
        if (newGuess[i] in newSecret && !evaluatedChars.contains(newGuess[i])) {
            wrong++
            evaluatedChars.add(newGuess[i])
        }
    }

     */

    println("newSecret $newSecret")
    println("newGuess $newGuess")
   /*
    val evaluatedChars = mutableListOf<Char>()
    for (i in secret.indices) {
        if (newGuess.contains(secret[i])) {
            wrong++
            newGuess = newGuess.replace(secret[i].toString(),"")
            println(newGuess)
            println(secret[i])
        }
    }

    */
/*
    for(i in secret.indices) {
        val letter = guess[i]
        if(secret[i] != guess[i]) {
            if(!evaluatedChars.contains(letter)) {
                wrong++
                evaluatedChars.add(letter)
                println(letter)
            }
        }
    }

 */


    //guess.forEachIndexed { i,c -> println("Index $i Character $c") }

    return Evaluation(rightPosition = right, wrongPosition = wrong)

}

