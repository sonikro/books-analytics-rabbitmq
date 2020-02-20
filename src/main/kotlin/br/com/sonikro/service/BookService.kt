package br.com.sonikro.service

import br.com.sonikro.model.Book
import io.micronaut.context.annotation.Context
import java.util.*
import javax.annotation.PostConstruct


@Context
class BookService {
    @PostConstruct
    fun init() {
        bookStore.add(Book("1491950358", "Building Microservices"))
        bookStore.add(Book("1680502395", "Release It!"))
        bookStore.add(Book("0321601912", "Continuous Delivery"))
    }

    fun listAll(): List<Book> {
        return bookStore
    }

    fun findByIsbn(isbn: String?): Optional<Book> {
        return bookStore.stream()
                .filter { b: Book -> b.isbn.equals(isbn) }
                .findFirst()
    }

    companion object {
        private val bookStore: MutableList<Book> = ArrayList<Book>()
    }
}