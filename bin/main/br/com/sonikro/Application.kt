package br.com.sonikro

import io.micronaut.runtime.Micronaut


object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("br.com.sonikro")
                .mainClass(Application.javaClass)
                .start()
    }
}