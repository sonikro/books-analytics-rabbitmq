package br.com.sonikro.filter

import br.com.sonikro.message.producer.AnalyticsClient
import br.com.sonikro.model.Book
import io.micronaut.http.HttpRequest
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Filter
import io.micronaut.http.filter.HttpServerFilter
import io.micronaut.http.filter.ServerFilterChain
import io.reactivex.Flowable
import org.reactivestreams.Publisher
import java.util.*


@Filter("/books/?*")
class AnalyticsFilter(private val analyticsClient: AnalyticsClient) : HttpServerFilter {
    override fun doFilter(request: HttpRequest<*>?, chain: ServerFilterChain): Publisher<MutableHttpResponse<*>> {
        return Flowable
                .fromPublisher(chain.proceed(request))
                .flatMap { response: MutableHttpResponse<*> ->
                    Flowable.fromCallable {
                        val book: Optional<Book> = response.getBody(Book::class.java)
                        book.ifPresent { book: Book? -> analyticsClient.updateAnalytics(book!!) }
                        response
                    }
                }
    }

}