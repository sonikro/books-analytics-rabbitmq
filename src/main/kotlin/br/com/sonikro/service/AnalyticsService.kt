package br.com.sonikro.service

import br.com.sonikro.model.Book
import br.com.sonikro.model.BookAnalytics
import java.util.concurrent.ConcurrentHashMap
import java.util.stream.Collectors
import javax.inject.Singleton


@Singleton
class AnalyticsService {
    private val bookAnalytics: MutableMap<Book, Long> = ConcurrentHashMap<Book, Long>()
    fun updateBookAnalytics(book: Book) {
        bookAnalytics.compute(book) { b: Book?, v: Long? ->
            if (v == null) {
                return@compute 1L
            } else {
                return@compute v + 1
            }
        }
    }

    fun listAnalytics(): List<BookAnalytics> {
        return (bookAnalytics
                .entries
                .stream()
                .map<Any> { e: Map.Entry<Book, Long> -> BookAnalytics(e.key.isbn, e.value) }
                .collect(Collectors.toList()) as List<BookAnalytics>?)!!
    }
}