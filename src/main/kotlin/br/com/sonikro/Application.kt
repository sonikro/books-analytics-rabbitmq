package br.com.sonikro

import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License

@OpenAPIDefinition(
        info = Info(
                title = "Books Analytics",
                version = "0.0",
                description = "API to list Books and generate analytics data using RabbitMQ",
                license = License(name = "Apache 2.0", url = "http://foo.bar"),
                contact = Contact(url = "https://cloud.sonikro.com", name = "Jonathan Nagayoshi", email = "jonathan@nagayoshi.com.br")
        )
)
object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("br.com.sonikro")
                .mainClass(Application.javaClass)
                .start()
    }
}