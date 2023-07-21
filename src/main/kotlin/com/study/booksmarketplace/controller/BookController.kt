package com.study.booksmarketplace.controller

import com.study.booksmarketplace.controller.request.CreateBookRequest
import com.study.booksmarketplace.extention.toBookModel
import com.study.booksmarketplace.service.BookService
import com.study.booksmarketplace.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("books")
class BookController (
    private val customerService: CustomerService,
    private val bookService: BookService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: CreateBookRequest) {
        val customer = customerService.getById(request.customerId)
        bookService.create(request.toBookModel(customer))
    }

}