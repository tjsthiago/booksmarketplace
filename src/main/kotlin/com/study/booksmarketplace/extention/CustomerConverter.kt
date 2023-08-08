package com.study.booksmarketplace.extention

import com.study.booksmarketplace.controller.request.CreateCustomerRequest
import com.study.booksmarketplace.controller.request.UpadateCustomerRequest
import com.study.booksmarketplace.model.CustomerModel
import com.study.booksmarketplace.model.enums.CustomerStatus

fun CreateCustomerRequest.toCustomerModel() : CustomerModel {
    return CustomerModel(
        name = this.name,
        email = this.email,
        status = CustomerStatus.ACTIVE
    )
}

fun UpadateCustomerRequest.toCustomerModel(previousValue: CustomerModel) : CustomerModel {
    return CustomerModel(
        id = previousValue.id,
        this.name,
        this.email,
        status = previousValue.status
    )
}