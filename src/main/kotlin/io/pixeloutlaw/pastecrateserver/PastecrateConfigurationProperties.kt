package io.pixeloutlaw.pastecrateserver

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("pastecrate")
class PastecrateConfigurationProperties {
    var pasteTimeToLive: Long = 60
}
