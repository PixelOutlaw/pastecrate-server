package io.pixeloutlaw.pastecrateserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PastecrateServerApplication

fun main(args: Array<String>) {
	runApplication<PastecrateServerApplication>(*args)
}
