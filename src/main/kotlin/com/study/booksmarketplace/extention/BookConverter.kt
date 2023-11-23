package com.study.booksmarketplace.extention

import com.study.booksmarketplace.controller.request.CreateBookRequest
import com.study.booksmarketplace.controller.request.UpdateBookRequest
import com.study.booksmarketplace.controller.response.BookResponse
import com.study.booksmarketplace.model.BookModel
import com.study.booksmarketplace.model.CustomerModel
import com.study.booksmarketplace.model.enums.BookStatus

fun CreateBookRequest.toModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ACTIVE,
        customer = customer
    )
}

fun UpdateBookRequest.toModel(previousValue: BookModel): BookModel {
    return BookModel(
        id = previousValue.id,
        name = this.name ?: previousValue.name,
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        customer = previousValue.customer
    )
}

fun BookModel.toResponse(): BookResponse {
    return BookResponse(
        id = this.id,
        name = this.name,
        price = this.price,
        status = this.status,
        customer = this.customer?.toResponse()
    )
}