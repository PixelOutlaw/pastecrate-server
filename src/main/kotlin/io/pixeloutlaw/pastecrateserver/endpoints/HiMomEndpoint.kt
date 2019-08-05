package io.pixeloutlaw.pastecrateserver.endpoints

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HiMomEndpoint {
    @GetMapping("/himom")
    fun sayHiMom(): String {
        return "Hi, Mom!"
    }
}
