package com.study.booksmarketplace.controller.response

import com.study.booksmarketplace.model.enums.BookStatus
import java.math.BigDecimal

data class BookResponse (
    var id: Long? = null,
    var name: String,
    var price: BigDecimal,
    var customer: CustomerResponse? = null,
    var status: BookStatus? = null
)