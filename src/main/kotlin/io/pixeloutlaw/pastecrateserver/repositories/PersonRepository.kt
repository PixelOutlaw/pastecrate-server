package io.pixeloutlaw.pastecrateserver.repositories

import io.pixeloutlaw.pastecrateserver.models.Person
import org.springframework.data.repository.CrudRepository

interface PersonRepository: CrudRepository<Person, String> {
}