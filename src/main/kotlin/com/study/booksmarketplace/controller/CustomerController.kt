package com.study.booksmarketplace.controller

import com.study.booksmarketplace.controller.request.CreateCustomerRequest
import com.study.booksmarketplace.controller.request.UpadateCustomerRequest
import com.study.booksmarketplace.controller.response.CustomerResponse
import com.study.booksmarketplace.extention.toModel
import com.study.booksmarketplace.extention.toResponse
import com.study.booksmarketplace.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customers")
class CustomerController (
    private val customerService: CustomerService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody createCustomerRequest: CreateCustomerRequest) {
        customerService.create(createCustomerRequest.toModel())
    }

    @GetMapping
    fun findAll(@RequestParam name: String?): List<CustomerResponse> {
        return customerService.findAll(name).map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): CustomerResponse {
        return customerService.findById(id).toResponse()
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Long, @RequestBody upadateCustomerRequest: UpadateCustomerRequest) {
        val customer = customerService.findById(id)
        customerService.update(upadateCustomerRequest.toModel(customer))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        customerService.deactivateById(id)
    }

}