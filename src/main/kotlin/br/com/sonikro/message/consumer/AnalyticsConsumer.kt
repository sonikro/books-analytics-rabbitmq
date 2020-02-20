package br.com.sonikro.message.consumer

import br.com.sonikro.model.Book
import br.com.sonikro.service.AnalyticsService
import io.micronaut.configuration.rabbitmq.annotation.Queue;
import io.micronaut.configuration.rabbitmq.annotation.RabbitListener;
import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;


@Requires(notEnv = [Environment.TEST])
@RabbitListener
class AnalyticsListener(private val analyticsService: AnalyticsService) {
    @Queue("analytics")
    fun updateAnalytics(book: Book?) {
        analyticsService.updateBookAnalytics(book!!)
    }

}