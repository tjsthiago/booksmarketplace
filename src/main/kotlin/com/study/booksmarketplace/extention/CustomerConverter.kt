package com.study.booksmarketplace.extention

import com.study.booksmarketplace.controller.request.CreateCustomerRequest
import com.study.booksmarketplace.controller.request.UpdateCustomerRequest
import com.study.booksmarketplace.controller.response.CustomerResponse
import com.study.booksmarketplace.model.CustomerModel
import com.study.booksmarketplace.model.enums.CustomerStatus

fun CreateCustomerRequest.toModel() : CustomerModel {
    return CustomerModel(
        name = this.name,
        email = this.email,
        status = CustomerStatus.ACTIVE
    )
}

fun UpdateCustomerRequest.toModel(previousValue: CustomerModel) : CustomerModel {
    return CustomerModel(
        id = previousValue.id,
        this.name,
        this.email,
        status = previousValue.status
    )
}

fun CustomerModel.toResponse(): CustomerResponse {
    return CustomerResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        status = this.status
    )
}