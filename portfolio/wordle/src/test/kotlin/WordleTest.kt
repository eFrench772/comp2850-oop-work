import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.collections.shouldBeIn

@Suppress("unused")
class WordleTest : StringSpec({
    
    "isValid should return true for 5-letter words, false otherwise" {
        isValid("guess") shouldBe true
        isValid("letters") shouldBe false
        isValid("") shouldBe false
        isValid("word") shouldBe false
    }

    "readWordList should return a not empty list" {
        val words = readWordList("data/words.txt")
        words.isNotEmpty() shouldBe true
        words.forEach { withClue(it) { it shouldBe it.toString() } }
    }

    "pickRandomWord should return a random word from the list then remove it" {
        val words = mutableListOf("quirk", "orbit", "guess", "moist", "phone")
        val chosen = pickRandomWord(words)
        chosen shouldBeIn listOf("quirk", "orbit", "guess", "moist", "phone")
        words.size shouldBe 4
        words.contains(chosen) shouldBe false
    }

    "evaluateGuess should correctly compare guess with target" {
        val target = "guess"
        evaluateGuess("guess", target) shouldBe listOf(1, 1, 1, 1, 1)
        evaluateGuess("guard", target) shouldBe listOf(1, 1, 0, 0, 0)
        evaluateGuess("phone", target) shouldBe listOf(0, 0, 0, 0, 0)
    }
})
