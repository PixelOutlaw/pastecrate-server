package io.pixeloutlaw.pastecrateserver.models

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash(value = "pastes", timeToLive = 60)
data class Paste(
    @Id val id: String,
    val language: String,
    val content: String
)
