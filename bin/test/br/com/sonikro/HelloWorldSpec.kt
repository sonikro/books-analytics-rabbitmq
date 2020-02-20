package br.com.sonikro

import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import javax.inject.Inject
import kotlin.test.assertEquals

@MicronautTest
class HelloWorldSpec {
    @Inject
    lateinit var server: EmbeddedServer

    @Inject
    @field:Client("/")
    lateinit var client: HttpClient

    fun testHelloWorldResponse() {
        val response: String = client.toBlocking()
                .retrieve("/hello")
        assertEquals("hello", response)
    }
}