package com.study.booksmarketplace.exption

import com.study.booksmarketplace.controller.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(exception: NotFoundException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            httpStatusCode = HttpStatus.NOT_FOUND,
            message = exception.message,
            internalCode = exception.errorCode,
            errors = emptyList()
        )

        return ResponseEntity(errorResponse, errorResponse.httpStatusCode)
    }

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(exception: BadRequestException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            httpStatusCode = HttpStatus.BAD_REQUEST,
            message = exception.message,
            internalCode = exception.errorCode,
            errors = emptyList()
        )

        return ResponseEntity(errorResponse, errorResponse.httpStatusCode)
    }
}