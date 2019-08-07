package io.pixeloutlaw.pastecrateserver.generators

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("pastecrate.generator")
data class GeneratorConfigurationProperties(val type: Type = Type.DEFAULT, val idLength: Int = 10) {
    enum class Type {
        PHONETIC,
        DEFAULT
    }
}