package com.study.booksmarketplace.controller

import com.study.booksmarketplace.controller.request.CreateBookRequest
import com.study.booksmarketplace.controller.request.UpdateBookRequest
import com.study.booksmarketplace.controller.response.BookResponse
import com.study.booksmarketplace.extention.toModel
import com.study.booksmarketplace.extention.toResponse
import com.study.booksmarketplace.service.BookService
import com.study.booksmarketplace.service.CustomerService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
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
    fun create(@RequestBody @Valid request: CreateBookRequest) {
        val customer = customerService.findById(request.customerId)
        bookService.create(request.toModel(customer))
    }

    @GetMapping
    fun findAll(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> {
        return bookService.findAll(pageable).map { it.toResponse() }
    }

    @GetMapping("/active")
    fun findActives(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> {
        return bookService.findActives(pageable).map { it.toResponse() }
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
    fun update(@PathVariable id: Long, @RequestBody @Valid request: UpdateBookRequest) {
        val persistedBook = bookService.findById(id)
        bookService.update(request.toModel(persistedBook))
    }

}