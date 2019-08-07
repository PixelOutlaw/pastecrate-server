package io.pixeloutlaw.pastecrateserver.generators

class RandomGibberishGenerator(override val defaultLength: Int) : StringGenerator {
    companion object {
        const val KEYS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
    }

    override fun generate(length: Int): String {
        require(length >= 0) { "Count 'length' must be non-negative, but was $length." }
        return KEYS.randomRepeat(length)
    }

    override fun generate(): String = generate(defaultLength)
}
