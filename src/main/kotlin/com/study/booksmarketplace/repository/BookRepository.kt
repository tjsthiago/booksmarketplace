package com.study.booksmarketplace.repository

import com.study.booksmarketplace.model.BookModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Long> {

}
