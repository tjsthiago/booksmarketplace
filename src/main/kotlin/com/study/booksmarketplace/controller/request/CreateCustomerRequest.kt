package com.study.booksmarketplace.controller.request

import com.study.booksmarketplace.validation.EmailAvailable
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class CreateCustomerRequest (
    @field:NotEmpty(message = "The customer name is mandatory")
    var name: String,

    @field:Email(message = "Should be a valid e-mail")
    @EmailAvailable
    var email: String
)