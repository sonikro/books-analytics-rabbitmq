package br.com.sonikro.model

import io.micronaut.core.annotation.Introspected


@Introspected
class BookAnalytics {
    var bookIsbn: String? = null
    var count: Long? = null

    constructor() {}
    constructor(bookIsbn: String?, count: Long?) {
        this.bookIsbn = bookIsbn
        this.count = count
    }

}