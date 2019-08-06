package io.pixeloutlaw.pastecrateserver.endpoints

import io.pixeloutlaw.pastecrateserver.models.Person
import io.pixeloutlaw.pastecrateserver.repositories.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PeopleEndpoint @Autowired constructor(private val personRepository: PersonRepository) {
    @GetMapping("/")
    fun root() = System.getenv("SPRING_REDIS_URL")

    @GetMapping("/people")
    fun getPeople(): List<Person> = personRepository.findAll().toList()

    @PostMapping("/people")
    fun createPerson(@RequestBody person: Person) = personRepository.save(person.copy(id = null))
}
