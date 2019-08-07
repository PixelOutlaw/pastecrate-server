package io.pixeloutlaw.pastecrateserver.repositories

import io.pixeloutlaw.pastecrateserver.models.Paste

interface CustomizedPasteRepository {
    fun createPaste(language: String, contents: String): Paste
}