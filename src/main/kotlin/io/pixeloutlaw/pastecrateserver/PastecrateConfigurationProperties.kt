package io.pixeloutlaw.pastecrateserver

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("pastecrate")
data class PastecrateConfigurationProperties(val pasteTimeToLive: Long = 60)
