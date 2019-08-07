package io.pixeloutlaw.pastecrateserver.models.responses

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.CREATED)
data class CreatePasteResponse(val id: String)
