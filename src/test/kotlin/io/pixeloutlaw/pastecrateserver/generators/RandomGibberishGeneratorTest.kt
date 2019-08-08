package io.pixeloutlaw.pastecrateserver.generators

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.regex.Pattern

internal class RandomGibberishGeneratorTest {
    lateinit var randomGibberishGenerator: RandomGibberishGenerator

    @BeforeEach
    fun setUp() {
        randomGibberishGenerator = RandomGibberishGenerator(10)
    }

    @Test
    fun `does generate() return a String of length 10`() {
        assertThat(randomGibberishGenerator.generate()).hasSize(10)
    }

    @Test
    fun `does generate(int) return a String of length equaling param`() {
        assertThat(randomGibberishGenerator.generate(5)).hasSize(5)
    }

    @Test
    fun `does generate include uppercase letters and lowercase letters and digits`() {
        val generatedString = randomGibberishGenerator.generate(100) // long enough to guarantee one of each
        val allRegex = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+\$")
        assertThat(generatedString).matches(allRegex)
    }
}