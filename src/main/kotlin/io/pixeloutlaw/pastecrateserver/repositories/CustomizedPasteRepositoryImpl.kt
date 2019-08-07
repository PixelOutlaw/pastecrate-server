package io.pixeloutlaw.pastecrateserver.repositories

import io.pixeloutlaw.pastecrateserver.generators.StringGenerator
import io.pixeloutlaw.pastecrateserver.models.Paste
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CustomizedPasteRepositoryImpl @Autowired constructor(private val idGenerator: StringGenerator) :
    CustomizedPasteRepository {
    override fun createPaste(language: String, contents: String): Paste = Paste(idGenerator.generate(), language, contents)
}
