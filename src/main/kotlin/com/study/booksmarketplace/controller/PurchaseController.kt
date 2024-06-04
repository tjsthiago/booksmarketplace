package com.study.booksmarketplace.controller

import com.study.booksmarketplace.controller.request.PurchaseRequest
import com.study.booksmarketplace.mapper.PurchaseMapper
import com.study.booksmarketplace.service.PurchaseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/purchase")
class PurchaseController(
    private val purchaseService: PurchaseService,
    private val purchaseMapper: PurchaseMapper
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun purchase(@RequestBody request: PurchaseRequest) {
        purchaseService.create(purchaseMapper.toModel(request))
    }

}