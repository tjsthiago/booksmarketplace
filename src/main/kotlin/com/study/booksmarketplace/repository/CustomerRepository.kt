package com.study.booksmarketplace.repository

import com.study.booksmarketplace.model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<CustomerModel, Long> {

    fun findByNameContainingIgnoreCase(pageable: Pageable, name: String) : Page<CustomerModel>

    fun existsByEmail(email: String): Boolean

}