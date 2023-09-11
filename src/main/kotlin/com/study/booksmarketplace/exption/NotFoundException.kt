package com.study.booksmarketplace.exption

class NotFoundException(
    override val message: String,
    val errorCode: String
) : Exception()
