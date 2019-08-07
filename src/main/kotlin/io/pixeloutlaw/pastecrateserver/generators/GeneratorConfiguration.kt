package io.pixeloutlaw.pastecrateserver.generators

import io.pixeloutlaw.pastecrateserver.generators.qualifiers.Gibberish
import io.pixeloutlaw.pastecrateserver.generators.qualifiers.Phonetic
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
@EnableConfigurationProperties(GeneratorConfigurationProperties::class)
class GeneratorConfiguration {
    @Bean
    @Phonetic
    fun randomPhoneticGenerator(generatorConfigurationProperties: GeneratorConfigurationProperties) =
        RandomPhoneticGenerator(generatorConfigurationProperties.idLength)

    @Bean
    @Gibberish
    fun randomGibberishGenerator(generatorConfigurationProperties: GeneratorConfigurationProperties) =
        RandomGibberishGenerator(generatorConfigurationProperties.idLength)

    @Bean
    @Primary
    fun generator(
        generatorConfigurationProperties: GeneratorConfigurationProperties,
        @Phonetic
        randomPhoneticGenerator: RandomPhoneticGenerator,
        @Gibberish
        randomGibberishGenerator: RandomGibberishGenerator
    ): StringGenerator =
        when (generatorConfigurationProperties.type) {
            GeneratorConfigurationProperties.Type.PHONETIC -> {
                randomPhoneticGenerator
            }
            else -> {
                randomGibberishGenerator
            }
        }
}