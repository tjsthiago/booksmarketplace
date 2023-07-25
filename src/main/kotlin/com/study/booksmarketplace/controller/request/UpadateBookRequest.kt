package com.study.booksmarketplace.controller.request

import java.math.BigDecimal

data class UpadateBookRequest (
    var name: String?,
    var price: BigDecimal?
)
