package com.study.booksmarketplace.controller.request

import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Digits
import jakarta.validation.constraints.NotEmpty
import java.math.BigDecimal

data class CreateBookRequest (
    @field:NotEmpty(message = "The book name is mandatory")
    var name: String,

    @field:DecimalMin(value = "0.0", inclusive = false, message = "The book price should be greater than zero")
    @Digits(integer = 3, fraction = 2, message = "The book price should be in the format 0.00")
    var price: BigDecimal,

    var customerId: Long
)
