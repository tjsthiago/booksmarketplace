package com.study.booksmarketplace.mapper

import com.study.booksmarketplace.controller.request.PurchaseRequest
import com.study.booksmarketplace.model.PurchaseModel
import com.study.booksmarketplace.service.BookService
import com.study.booksmarketplace.service.CustomerService
import org.springframework.stereotype.Component

@Component
class PurchaseMapper(
    private val bookService: BookService,
    private val customerService: CustomerService
) {

    fun toModel(request: PurchaseRequest): PurchaseModel {
        val customer = customerService.findById(request.customerId)
        val books = bookService.findAllByIds(request.bookIds)

        return PurchaseModel(
            customer = customer,
            books = books,
            price = books.sumOf { it.price }
        )
    }

}