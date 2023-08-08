package com.study.booksmarketplace.service

import com.study.booksmarketplace.model.BookModel
import com.study.booksmarketplace.model.CustomerModel
import com.study.booksmarketplace.model.enums.BookStatus
import com.study.booksmarketplace.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService (
    private val bookRepository: BookRepository
) {

    fun create(book: BookModel) {
        bookRepository.save(book)
    }

    fun findAll(): List<BookModel> {
        return bookRepository.findAll().toList()
    }

    fun findActivers(): List<BookModel> {
        return bookRepository.findByStatus(BookStatus.ACTIVE)
    }

    fun findById(id: Long): BookModel {
        return bookRepository.findById(id).orElseThrow {
            throw Exception("Book with $id not found")
        }
    }

    fun deleteById(id: Long) {
        val book = findById(id)

        book.status = BookStatus.DELETED

        update(book)
    }

    fun update(book: BookModel) {
        bookRepository.save(book)
    }

    fun deleteByCustomer(customer: CustomerModel) {
        val books = bookRepository.findByCustomer(customer)

        books.forEach {
            it.status = BookStatus.DELETED
        }

        bookRepository.saveAll(books)
    }
}
