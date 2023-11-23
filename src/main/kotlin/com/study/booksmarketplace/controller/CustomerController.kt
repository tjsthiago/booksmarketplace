package com.study.booksmarketplace.controller

import com.study.booksmarketplace.controller.request.CreateCustomerRequest
import com.study.booksmarketplace.controller.request.UpdateCustomerRequest
import com.study.booksmarketplace.controller.response.CustomerResponse
import com.study.booksmarketplace.extention.toModel
import com.study.booksmarketplace.extention.toResponse
import com.study.booksmarketplace.service.CustomerService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customers")
class CustomerController (
    private val customerService: CustomerService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid createCustomerRequest: CreateCustomerRequest) {
        customerService.create(createCustomerRequest.toModel())
    }

    @GetMapping
    fun findAll(
        @PageableDefault(page = 0, size = 10) pageable: Pageable,
        @RequestParam name: String?
    ): Page<CustomerResponse> {
        return customerService.findAll(pageable, name).map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): CustomerResponse {
        return customerService.findById(id).toResponse()
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Long, @RequestBody @Valid updateCustomerRequest: UpdateCustomerRequest) {
        val customer = customerService.findById(id)
        customerService.update(updateCustomerRequest.toModel(customer))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        customerService.deactivateById(id)
    }

}