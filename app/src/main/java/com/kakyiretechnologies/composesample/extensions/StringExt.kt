package com.kakyiretechnologies.composesample.extensions


/**
 * @author Kakyire
 * Created by Daniel Frimpong on December 07, 2023.
 * https://github.com/kakyire
 */

val String.firstLetter
    get() = this.first().toString()

val String.initials
    get() = this.split(" ")
        .joinToString("") {
            it.take(1)
        }