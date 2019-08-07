package io.pixeloutlaw.pastecrateserver.generators

/**
 * Returns a [String] containing a [n] random [Char]s from this char sequence.
 * @throws [IllegalArgumentException] when n < 0.
 */
fun CharSequence.randomRepeat(n: Int): String {
    require(n >= 0) { "Count 'n' must be non-negative, but was $n." }
    return when (n) {
        0 -> ""
        1 -> this.toString()
        else -> {
            when (length) {
                0 -> ""
                1 -> this[0].let { char -> String(CharArray(n) { char }) }
                else -> {
                    val sb = StringBuilder(n * length)
                    for (i in 1..n) {
                        sb.append(this.random())
                    }
                    sb.toString()
                }
            }
        }
    }
}