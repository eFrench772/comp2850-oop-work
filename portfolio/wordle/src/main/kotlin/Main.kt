import kotlin.system.exitProcess


fun main() {
   // test main not acc gonna be used
   val words = readWordList("data/words.txt") //make words.txt into list
   val chosen = pickRandomWord(words) //pick random word and remove from list then save word
   val valid = isValid(chosen)

   println("you have 10 tries to guess the word")
   for (i in 1..10) {
    var guess = obtainGuess(i)
    var matchList = evaluateGuess(guess, chosen)
    displayGuess(guess, matchList)
    if (guess == chosen) {
      println("well done you got the correct word ${chosen} in ${i} guesses ")
      exitProcess(0)
    }
   }
   println("Oh no! you ran out of guesses the word was ${chosen}")
   exitProcess(0)
}
