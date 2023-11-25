package com.study.booksmarketplace.service

import com.study.booksmarketplace.exption.NotFoundException
import com.study.booksmarketplace.model.CustomerModel
import com.study.booksmarketplace.model.enums.CustomerStatus
import com.study.booksmarketplace.model.enums.Errors
import com.study.booksmarketplace.repository.CustomerRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CustomerService (
    private val customerRepository: CustomerRepository,
) {
    fun create(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun findById(id: Long): CustomerModel {
        return customerRepository.findById(id).orElseThrow{
            throw NotFoundException(
                Errors.CUSTOMER_NOT_FOUND.message.format(id),
                Errors.CUSTOMER_NOT_FOUND.code
            )
        }
    }

    fun findAll(pageable: Pageable, name: String?): Page<CustomerModel> {
        name?.let{
            return customerRepository.findByNameContainingIgnoreCase(pageable, name)
        }

        return customerRepository.findAll(pageable)
    }

    fun update(customer: CustomerModel) {
        if(!customerRepository.existsById(customer.id!!)) {
            throw NotFoundException(
                Errors.CUSTOMER_NOT_FOUND.message.format(customer.id),
                Errors.CUSTOMER_NOT_FOUND.code
            )
        }

        customerRepository.save(customer)
    }

    fun deactivateById(id: Long) {
        val customer = findById(id)
        customer.status = CustomerStatus.INACTIVE
        customerRepository.save(customer)
    }

    fun isEmailAvailable(email: String): Boolean {
        return !customerRepository.existsByEmail(email)
    }

}