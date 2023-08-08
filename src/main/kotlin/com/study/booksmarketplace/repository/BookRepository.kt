package com.study.booksmarketplace.repository

import com.study.booksmarketplace.model.BookModel
import com.study.booksmarketplace.model.enums.BookStatus
import com.study.booksmarketplace.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Long> {
    fun findByStatus(active: BookStatus): List<BookModel>

    fun findByCustomer(customer: CustomerModel): List<BookModel>

}
