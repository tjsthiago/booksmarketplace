package com.study.booksmarketplace.controller

import com.study.booksmarketplace.controller.request.CreateBookRequest
import com.study.booksmarketplace.controller.request.UpadateBookRequest
import com.study.booksmarketplace.extention.toBookModel
import com.study.booksmarketplace.model.BookModel
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

    @GetMapping
    fun findAll(): List<BookModel> {
        return bookService.findAll()
    }

    @GetMapping("/active")
    fun findActives(): List<BookModel> {
        return bookService.findActivers()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): BookModel {
        return bookService.findById(id)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable id: Long) {
        bookService.deleteById(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Long, @RequestBody request: UpadateBookRequest) {
        val persistedBook = bookService.findById(id)
        bookService.update(request.toBookModel(persistedBook))
    }

}