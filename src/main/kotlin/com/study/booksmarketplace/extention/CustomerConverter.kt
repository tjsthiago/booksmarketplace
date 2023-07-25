package com.study.booksmarketplace.extention

import com.study.booksmarketplace.controller.request.CreateCustomerRequest
import com.study.booksmarketplace.controller.request.UpadateCustomerRequest
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