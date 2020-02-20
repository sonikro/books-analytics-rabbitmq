package br.com.sonikro.message.producer

import br.com.sonikro.model.Book
import io.micronaut.configuration.rabbitmq.annotation.Binding
import io.micronaut.configuration.rabbitmq.annotation.RabbitClient

@RabbitClient("micronaut")
interface AnalyticsClient {
    @Binding("analytics")
    fun updateAnalytics(book: Book)
}