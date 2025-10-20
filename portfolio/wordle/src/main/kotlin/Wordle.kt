// Implement the six required functions here
import java.io.File
import kotlin.system.exitProcess

fun readWordList(filename: String): MutableList<String> {
   return File(filename).readLines().toMutableList()
}

fun pickRandomWord(words: MutableList<String>): String {
   val randomWord = words.random()  // Pick one at random
   words.remove(randomWord)         // Remove it from the list
   return randomWord 
}

fun isValid(word: String): Boolean {
   if (word.length == 5) {
      return true
   } else {
      return false
   }
}

fun obtainGuess(attempt: Int): String {
   println("Attempt $attempt:")
   var guess = readln()
   guess = guess.uppercase()
   if (guess.length == 5){
      return guess
   } else {
      println("your guess was invalid try again")
      return obtainGuess(attempt)
   }
}

fun evaluateGuess(guess: String, target: String): List<Int> {
   val guessletters = guess.toList()
   val targetLetters = target.toList()
   var check = mutableListOf<Int>()

   for (i in 0..4) {
      if (guessletters[i] == targetLetters[i]) {
         check.add(1)
      } else {
         check.add(0)
      }
   }
   return check
}

fun displayGuess(guess: String, matches: List<Int>) {
   val guessletters = guess.toList()
   var presentedList = mutableListOf<Char>()
   for (i in 0..4) {
      if (matches[i] == 1){
         presentedList.add(guessletters[i])
      } else {
         presentedList.add('?')
      }
   }
   println(presentedList)
}