package br.com.sonikro.controller

import br.com.sonikro.model.BookAnalytics
import br.com.sonikro.service.AnalyticsService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get


@Controller("/analytics")
class AnalyticsController(analyticsService: AnalyticsService) {
    private var analyticsService = analyticsService
    @Get("/")
    fun listAnalytics(): List<BookAnalytics> {
        return analyticsService.listAnalytics()
    }

}