package com.study.booksmarketplace.repository

import com.study.booksmarketplace.model.BookModel
import com.study.booksmarketplace.model.enums.BookStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<BookModel, Long> {

    fun findByStatus(pageable: Pageable, active: BookStatus): Page<BookModel>

}
