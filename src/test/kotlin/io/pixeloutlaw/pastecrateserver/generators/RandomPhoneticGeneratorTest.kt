package io.pixeloutlaw.pastecrateserver.generators

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.data.Offset
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.regex.Pattern

internal class RandomPhoneticGeneratorTest {
    lateinit var randomPhoneticGenerator: RandomPhoneticGenerator

    @BeforeEach
    fun setUp() {
        randomPhoneticGenerator = RandomPhoneticGenerator(10)
    }

    @Test
    fun `does generate() return a String of length 10`() {
        assertThat(randomPhoneticGenerator.generate()).hasSize(10)
    }

    @Test
    fun `does generate(int) return a String of length equaling param`() {
        assertThat(randomPhoneticGenerator.generate(5)).hasSize(5)
    }

    @Test
    fun `does generate return a String including vowels and consonants`() {
        val generatedString = randomPhoneticGenerator.generate()
        val allRegex = Pattern.compile("^(?=.*[aeiou])(?=.*[bcdfghjklmnpqrstvwxyz]).+\$")
        assertThat(generatedString).matches(allRegex)
    }

    @Test
    fun `does generate return a String with roughly equal amounts of vowels and consonants`() {
        val generatedString = randomPhoneticGenerator.generate()
        val consonants = generatedString.filter { RandomPhoneticGenerator.CONSONANTS.contains(it.toLowerCase()) }
        val vowels = generatedString.filter { RandomPhoneticGenerator.VOWELS.contains(it.toLowerCase()) }
        val half = generatedString.length / 2
        assertThat(consonants.length).isCloseTo(half, Offset.offset(1))
        assertThat(vowels.length).isCloseTo(half, Offset.offset(1))
    }

    @Test
    fun `does generate return a String with alternating vowels and consonants`() {
        val generatedString = randomPhoneticGenerator.generate()
        var checkVowel = if (RandomPhoneticGenerator.VOWELS.contains(generatedString.first())) {
            0
        } else {
            1
        }
        generatedString.forEachIndexed { index, c ->
            if (index % 2 == checkVowel) {
                assertThat(c).isIn(RandomPhoneticGenerator.VOWELS.toList())
            } else {
                assertThat(c).isIn(RandomPhoneticGenerator.CONSONANTS.toList())
            }
        }
    }
}