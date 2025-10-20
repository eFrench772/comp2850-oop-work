// Implement the six required functions here
import java.io.File


fun main() {
    // test main not acc gonna be used
    val words = readWordList("wordle/data/words.txt")

    println("Loaded ${words.size} words")
    println(words.take(10))
 }

fun readWordList(filename: String): MutableList<String> {
   return File(filename).readLines().toMutableList()
}