package com.study.booksmarketplace.service

import com.study.booksmarketplace.model.BookModel
import com.study.booksmarketplace.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService (
    private val bookRepository: BookRepository
) {

    fun create(book: BookModel) {
        bookRepository.save(book)
    }
}
