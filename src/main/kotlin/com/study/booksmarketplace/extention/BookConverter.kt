package com.study.booksmarketplace.extention

import com.study.booksmarketplace.controller.request.CreateBookRequest
import com.study.booksmarketplace.controller.request.UpadateBookRequest
import com.study.booksmarketplace.model.BookModel
import com.study.booksmarketplace.model.enums.BookStatus
import com.study.booksmarketplace.model.CustomerModel

fun CreateBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ACTIVE,
        customer = customer
    )
}

fun UpadateBookRequest.toBookModel(previousValue: BookModel): BookModel {
    return BookModel(
        id = previousValue.id,
        name = this.name ?: previousValue.name,
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        customer = previousValue.customer
    )
}