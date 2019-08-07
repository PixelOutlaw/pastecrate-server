package io.pixeloutlaw.pastecrateserver.generators

/**
 * Simple interface for something that generates a [String].
 */
interface StringGenerator {
    /**
     * Default length of a generated [String].
     */
    val defaultLength: Int

    /**
     * Generates a [String] of a given [length].
     *
     * @param length length of the generated String
     *
     * @return generated [String]
     */
    fun generate(length: Int): String

    /**
     * Generates a [String] of with a length of [defaultLength].
     */
    fun generate(): String
}