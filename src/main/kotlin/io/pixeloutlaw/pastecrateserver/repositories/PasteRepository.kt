package io.pixeloutlaw.pastecrateserver.repositories

import io.pixeloutlaw.pastecrateserver.models.Paste
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PasteRepository : CrudRepository<Paste, String>, CustomizedPasteRepository {
}
