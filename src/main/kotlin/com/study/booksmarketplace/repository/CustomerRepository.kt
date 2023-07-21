package com.study.booksmarketplace.repository

import com.study.booksmarketplace.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<CustomerModel, Long> {

    fun findByNameContainingIgnoreCase(name: String) : List<CustomerModel>

}