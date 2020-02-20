package br.com.sonikro.controller

import br.com.sonikro.model.Book
import br.com.sonikro.service.BookService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import java.util.*
import javax.inject.Inject


@Controller("/books")
class BookController {
    @Inject
    private lateinit var bookService: BookService

    @Get("/")
    fun listAll(): List<Book?>? {
        return bookService.listAll()
    }

    @Get("/{isbn}")
    fun findBook(isbn: String?): Optional<Book> {
        return bookService.findByIsbn(isbn)
    }
}