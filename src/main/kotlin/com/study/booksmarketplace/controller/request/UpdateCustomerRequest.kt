package com.study.booksmarketplace.controller.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class UpdateCustomerRequest (
    @field:NotEmpty(message = "Should be not empty")
    var name: String,

    @field:Email(message = "Should be a valid e-mail")
    var email: String
)