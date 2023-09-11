package com.study.booksmarketplace.controller.response

import org.springframework.http.HttpStatusCode

data class ErrorResponse(
    var httpStatusCode: HttpStatusCode,
    var message: String,
    var internalCode: String,
    var errors: List<FieldErrorResponse>
)
