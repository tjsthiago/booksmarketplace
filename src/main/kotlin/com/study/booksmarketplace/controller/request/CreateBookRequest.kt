package com.study.booksmarketplace.controller.request

import java.math.BigDecimal

data class CreateBookRequest (
    var name: String,
    var price: BigDecimal,
    var customerId: Long
)
