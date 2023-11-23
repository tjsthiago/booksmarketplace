package com.study.booksmarketplace.exption

import com.study.booksmarketplace.controller.response.ErrorResponse
import com.study.booksmarketplace.controller.response.FieldErrorResponse
import com.study.booksmarketplace.model.enums.Errors
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(exception: NotFoundException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            httpStatusCode = HttpStatus.NOT_FOUND.value(),
            message = exception.message,
            internalCode = exception.errorCode,
            errors = emptyList()
        )

        return ResponseEntity(errorResponse, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(exception: BadRequestException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            httpStatusCode = HttpStatus.BAD_REQUEST.value(),
            message = exception.message,
            internalCode = exception.errorCode,
            errors = emptyList()
        )

        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(exception: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            httpStatusCode = HttpStatus.UNPROCESSABLE_ENTITY.value(),
            message = Errors.UNPROCESSABLE_ENTITY.message,
            internalCode = Errors.UNPROCESSABLE_ENTITY.code,
            errors = exception.bindingResult.fieldErrors.map {
                FieldErrorResponse(
                    field = it.field,
                    message = it.defaultMessage ?: ""
                )
            }
        )

        return ResponseEntity(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY)
    }
}