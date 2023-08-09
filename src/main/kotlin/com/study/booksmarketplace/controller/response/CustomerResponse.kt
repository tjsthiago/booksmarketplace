package com.study.booksmarketplace.controller.response

import com.study.booksmarketplace.model.enums.CustomerStatus

data class CustomerResponse(
    var id: Long? = null,
    var name: String,
    var email: String,
    var status: CustomerStatus
)
