package io.pixeloutlaw.pastecrateserver.models.entities

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive

@RedisHash(value = "pastes")
data class Paste(
    @Id val id: String,
    val language: String,
    val content: String,
    @TimeToLive val timeToLive: Long = 60
)
