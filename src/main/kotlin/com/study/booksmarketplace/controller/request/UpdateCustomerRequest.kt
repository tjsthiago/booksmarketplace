package com.study.booksmarketplace.controller.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class UpdateCustomerRequest (
    @field:NotEmpty(message = "The customer name is mandatory")
    var name: String,

    @field:Email(message = "Should be a valid e-mail")
    var email: String
)