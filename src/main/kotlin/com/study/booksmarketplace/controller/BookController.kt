package com.study.booksmarketplace.controller

import com.study.booksmarketplace.controller.request.CreateBookRequest
import com.study.booksmarketplace.controller.request.UpadateBookRequest
import com.study.booksmarketplace.controller.response.BookResponse
import com.study.booksmarketplace.extention.toModel
import com.study.booksmarketplace.extention.toResponse
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
        val customer = customerService.findById(request.customerId)
        bookService.create(request.toModel(customer))
    }

    @GetMapping
    fun findAll(): List<BookResponse> {
        return bookService.findAll().map { it.toResponse() }
    }

    @GetMapping("/active")
    fun findActives(): List<BookResponse> {
        return bookService.findActivers().map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): BookResponse {
        return bookService.findById(id).toResponse()
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
        bookService.update(request.toModel(persistedBook))
    }

}