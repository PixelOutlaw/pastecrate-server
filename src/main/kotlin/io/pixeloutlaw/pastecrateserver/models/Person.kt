package io.pixeloutlaw.pastecrateserver.models

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import java.io.Serializable

@RedisHash("people")
data class Person(
    @Id val id: String?,
    val firstName: String,
    val lastName: String
): Serializable
