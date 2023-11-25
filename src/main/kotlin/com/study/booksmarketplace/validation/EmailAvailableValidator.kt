package com.study.booksmarketplace.validation

import com.study.booksmarketplace.service.CustomerService
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class EmailAvailableValidator (
    private val customerService: CustomerService
): ConstraintValidator<EmailAvailable, String> {

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
       if(value.isNullOrEmpty()) {
           return false
       }

        return customerService.isEmailAvailable(value)
    }

}
