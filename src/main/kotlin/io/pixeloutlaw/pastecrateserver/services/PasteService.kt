package io.pixeloutlaw.pastecrateserver.services

import io.pixeloutlaw.pastecrateserver.PastecrateConfigurationProperties
import io.pixeloutlaw.pastecrateserver.exceptions.PasteNotFoundException
import io.pixeloutlaw.pastecrateserver.generators.StringGenerator
import io.pixeloutlaw.pastecrateserver.models.entities.Paste
import io.pixeloutlaw.pastecrateserver.repositories.PasteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PasteService @Autowired constructor(
    private val idGenerator: StringGenerator,
    private val pastecrateConfigurationProperties: PastecrateConfigurationProperties,
    private val pasteRepository: PasteRepository
) {
    fun getAllPastes(): List<Paste> = pasteRepository.findAll().filterNotNull().toList()

    fun getPasteById(id: String): Paste = pasteRepository.findByIdOrNull(id) ?: throw PasteNotFoundException(id)

    fun createPaste(language: String, content: String) = pasteRepository.save(
        Paste(
            idGenerator.generate(),
            language,
            content,
            pastecrateConfigurationProperties.pasteTimeToLive
        )
    )

    fun deletePasteById(id: String) = pasteRepository.deleteById(id)
}