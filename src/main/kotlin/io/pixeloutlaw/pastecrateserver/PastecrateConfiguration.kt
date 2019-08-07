package io.pixeloutlaw.pastecrateserver

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories

@Configuration
@EnableConfigurationProperties(PastecrateConfigurationProperties::class)
@EnableRedisRepositories
class PastecrateConfiguration