package com.study.booksmarketplace.controller.request

import java.math.BigDecimal

data class UpdateBookRequest (
    var name: String?,
    var price: BigDecimal?
)
