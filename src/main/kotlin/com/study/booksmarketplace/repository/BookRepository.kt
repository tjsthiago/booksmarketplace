package com.study.booksmarketplace.repository

import com.study.booksmarketplace.model.BookModel
import com.study.booksmarketplace.model.BookStatus
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Long> {
    fun findByStatus(active: BookStatus): List<BookModel>

}
