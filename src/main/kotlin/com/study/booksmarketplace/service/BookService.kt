package com.study.booksmarketplace.service

import com.study.booksmarketplace.exption.NotFoundException
import com.study.booksmarketplace.model.BookModel
import com.study.booksmarketplace.model.enums.BookStatus
import com.study.booksmarketplace.model.enums.Errors
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

    fun findActives(pageable: Pageable): Page<BookModel> {
        return bookRepository.findByStatus(pageable, BookStatus.ACTIVE)
    }

    fun findById(id: Long): BookModel {
        return bookRepository.findById(id).orElseThrow {
            throw NotFoundException(
                Errors.BOOK_NOT_FOUND.message.format(id),
                Errors.BOOK_NOT_FOUND.code
            )
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

    fun findAllByIds(bookIds: Set<Long>): List<BookModel> {
        return bookRepository.findAllById(bookIds.asIterable()).toList()
    }
}
