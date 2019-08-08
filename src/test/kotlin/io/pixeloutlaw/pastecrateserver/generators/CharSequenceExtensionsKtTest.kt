package io.pixeloutlaw.pastecrateserver.generators

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.regex.Pattern

internal class CharSequenceExtensionsKtTest {
    @Test
    fun `does randomRepeat(int) return a String of length of passed param`() {
        assertThat("a".randomRepeat(4)).hasSize(4)
    }

    @Test
    fun `does randomRepeat(int) return a String only containing values from String`() {
        assertThat("ab".randomRepeat(10)).matches(Pattern.compile("^[ab]+$"))
    }

    @Test
    fun `does randomRepeat(int) return a String with random amounts of each value`() {
        val charsToOccurrences = mutableMapOf<Char, Int>()
        val stringToTest = "abc".randomRepeat(100) // large enough to get a relatively solid sampling
        for (c in stringToTest) {
            charsToOccurrences[c] = charsToOccurrences.getOrDefault(c, 0) + 1
        }
        // check that there are enough of each character, but not so many to get messed up by rng
        assertThat(charsToOccurrences['a']).isGreaterThanOrEqualTo(20)
        assertThat(charsToOccurrences['b']).isGreaterThanOrEqualTo(20)
        assertThat(charsToOccurrences['c']).isGreaterThanOrEqualTo(20)
    }
}