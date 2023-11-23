package com.study.booksmarketplace.exption

class BadRequestException(
    override val message: String,
    val errorCode: String
) : Exception()
