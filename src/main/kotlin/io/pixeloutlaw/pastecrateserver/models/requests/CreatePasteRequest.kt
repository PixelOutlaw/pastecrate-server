package io.pixeloutlaw.pastecrateserver.models.requests

data class CreatePasteRequest(
    val language: String,
    val content: String
)
