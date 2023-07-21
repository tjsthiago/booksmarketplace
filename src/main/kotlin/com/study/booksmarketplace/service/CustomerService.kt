package com.study.booksmarketplace.service

import com.study.booksmarketplace.model.CustomerModel
import com.study.booksmarketplace.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService (
    private val customerRepository: CustomerRepository
) {
    fun create(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun getById(id: Long): CustomerModel {
        return customerRepository.findById(id).orElseThrow{
            throw Exception("Customer with $id not found")
        }
    }

    fun findAll(name: String?): List<CustomerModel> {
        name?.let{
            return customerRepository.findByNameContainingIgnoreCase(name)
        }

        return customerRepository.findAll().toList()
    }

    fun update(customer: CustomerModel) {
        if(!customerRepository.existsById(customer.id!!)) {
            throw Exception("Customer with ${customer.id!!} not found")
        }

        customerRepository.save(customer)
    }

    fun delete(id: Long) {
        if(!customerRepository.existsById(id)) {
            throw Exception("Customer with $id not found")
        }

        customerRepository.deleteById(id)
    }

}