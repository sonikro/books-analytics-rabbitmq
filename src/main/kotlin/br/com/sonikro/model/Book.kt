package br.com.sonikro.model

import io.micronaut.core.annotation.Introspected
import java.util.*


@Introspected
class Book {
    var isbn: String? = null
    var name: String? = null

    constructor() {}
    constructor(isbn: String?, name: String?) {
        this.isbn = isbn
        this.name = name
    }

    override fun toString(): String {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                '}'
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val book = o as Book
        return isbn == book.isbn &&
                name == book.name
    }

    override fun hashCode(): Int {
        return Objects.hash(isbn, name)
    }
}