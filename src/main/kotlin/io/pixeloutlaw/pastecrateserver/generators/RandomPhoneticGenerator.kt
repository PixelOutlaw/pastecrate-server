package io.pixeloutlaw.pastecrateserver.generators

import kotlin.math.roundToInt

class RandomPhoneticGenerator(override val defaultLength: Int) : StringGenerator {
    companion object {
        const val CONSONANTS = "bcdfghjklmnpqrstvwxyz"
        const val VOWELS = "aeiou"
    }

    override fun generate(length: Int): String {
        require(length >= 0) { "Count 'length' must be non-negative, but was $length." }
        val moduloForConsonant = Math.random().roundToInt()
        val sb = StringBuilder(length)
        for (i in 0 until length) {
            val charToAppend = if (i % 2 == moduloForConsonant) {
                CONSONANTS.random()
            } else {
                VOWELS.random()
            }
            sb.append(charToAppend)
        }
        return sb.toString()
    }

    override fun generate(): String = generate(defaultLength)
}
