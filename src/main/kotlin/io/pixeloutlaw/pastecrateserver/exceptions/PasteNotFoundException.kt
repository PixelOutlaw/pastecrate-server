package io.pixeloutlaw.pastecrateserver.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class PasteNotFoundException(val id: String) : RuntimeException("Unable to find paste with id=$id")
