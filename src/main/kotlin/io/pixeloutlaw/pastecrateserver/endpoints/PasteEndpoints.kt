package io.pixeloutlaw.pastecrateserver.endpoints

import io.pixeloutlaw.pastecrateserver.models.requests.CreatePasteRequest
import io.pixeloutlaw.pastecrateserver.models.responses.CreatePasteResponse
import io.pixeloutlaw.pastecrateserver.models.responses.PasteResponse
import io.pixeloutlaw.pastecrateserver.models.responses.PastesResponse
import io.pixeloutlaw.pastecrateserver.services.PasteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class PasteEndpoints @Autowired constructor(private val pasteService: PasteService) {
    @GetMapping
    fun getPastes() =
        PastesResponse(pasteService.getAllPastes().map { PasteResponse(it.id, it.language, it.content) })

    @GetMapping("/{id}")
    fun getPasteById(@PathVariable("id") id: String) =
        pasteService.getPasteById(id).let { PasteResponse(it.id, it.language, it.content) }

    @PostMapping
    fun createPaste(@RequestBody createPasteRequest: CreatePasteRequest) = pasteService.createPaste(
        createPasteRequest.language,
        createPasteRequest.content
    ).let { CreatePasteResponse(it.id) }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePasteById(@PathVariable("id") id: String): Unit = pasteService.deletePasteById(id)
}