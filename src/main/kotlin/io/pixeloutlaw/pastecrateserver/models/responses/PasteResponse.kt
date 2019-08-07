package io.pixeloutlaw.pastecrateserver.models.responses

data class PasteResponse(
    val id: String,
    val language: String,
    val content: String
)