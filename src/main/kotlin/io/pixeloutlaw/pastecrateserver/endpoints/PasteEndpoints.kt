package io.pixeloutlaw.pastecrateserver.endpoints

import io.pixeloutlaw.pastecrateserver.models.Paste
import io.pixeloutlaw.pastecrateserver.repositories.PasteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PasteEndpoints @Autowired constructor(private val pasteRepository: PasteRepository) {
    @GetMapping
    fun getPastes(): List<Paste> = pasteRepository.findAll().filterNotNull().toList()

    @GetMapping("/{id}")
    fun getPasteById(@PathVariable("id") id: String): Paste? = pasteRepository.findByIdOrNull(id)

    @PostMapping
    fun createPaste(@RequestBody paste: Paste): String =
        pasteRepository.save(pasteRepository.createPaste(paste.language, paste.content)).id

    @DeleteMapping("/{id}")
    fun deletePasteById(@PathVariable("id") id: String): Unit = pasteRepository.deleteById(id)
}