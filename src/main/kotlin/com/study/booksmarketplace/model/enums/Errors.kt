package com.study.booksmarketplace.model.enums

enum class Errors(val code: String, val message: String) {
    BOOK_NOT_FOUND("ML-1001", "Book with id %s not found"),
    BOOK_UPDATE_NOT_ALLOWED("ML-1002", "It is not allowed to update a book with %s status"),
    CUSTOMER_NOT_FOUND("ML-2002", "Customer with id %s not found")
}
