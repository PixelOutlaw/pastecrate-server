package io.pixeloutlaw.pastecrateserver.generators.qualifiers

import org.springframework.beans.factory.annotation.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.TYPE,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.FIELD,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.ANNOTATION_CLASS,
    AnnotationTarget.VALUE_PARAMETER
)
annotation class Gibberish