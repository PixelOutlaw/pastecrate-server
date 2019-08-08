package io.pixeloutlaw.pastecrateserver.generators

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("pastecrate.generator")
class GeneratorConfigurationProperties() {
    var type: Type = Type.DEFAULT
    var idLength: Int = 10

    enum class Type {
        PHONETIC,
        DEFAULT
    }
}