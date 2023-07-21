package com.study.booksmarketplace.extention

import com.study.booksmarketplace.controller.request.CreateBookRequest
import com.study.booksmarketplace.controller.request.CreateCustomerRequest
import com.study.booksmarketplace.controller.request.UpadateCustomerRequest
import com.study.booksmarketplace.model.BookModel
import com.study.booksmarketplace.model.BookStatus
import com.study.booksmarketplace.model.CustomerModel

fun CreateCustomerRequest.toCustomerModel() : CustomerModel {
    return CustomerModel(
        name = this.name,
        email = this.email
    )
}

fun UpadateCustomerRequest.toCustomerModel(id: Long) : CustomerModel {
    return CustomerModel(id, this.name, this.email)
}

fun CreateBookRequest.toBookModel(customer: CustomerModel) : BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ACTIVE,
        customer = customer
    )
}