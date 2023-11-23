package com.study.booksmarketplace.controller.response

data class ErrorResponse(
    var httpStatusCode: Int,
    var message: String,
    var internalCode: String,
    var errors: List<FieldErrorResponse>
)
