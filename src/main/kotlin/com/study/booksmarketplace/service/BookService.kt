package com.study.booksmarketplace.service

import com.study.booksmarketplace.exption.NotFoundException
import com.study.booksmarketplace.model.BookModel
import com.study.booksmarketplace.model.enums.BookStatus
import com.study.booksmarketplace.repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService (
    private val bookRepository: BookRepository
) {

    fun create(book: BookModel) {
        bookRepository.save(book)
    }

    fun findAll(pageable: Pageable): Page<BookModel> {
        return bookRepository.findAll(pageable)
    }

    fun findActivers(pageable: Pageable): Page<BookModel> {
        return bookRepository.findByStatus(pageable, BookStatus.ACTIVE)
    }

    fun findById(id: Long): BookModel {
        return bookRepository.findById(id).orElseThrow {
            throw NotFoundException("Book with $id not found")
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
}
