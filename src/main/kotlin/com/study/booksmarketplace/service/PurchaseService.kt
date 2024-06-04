package com.study.booksmarketplace.service

import com.study.booksmarketplace.model.PurchaseModel
import com.study.booksmarketplace.repository.PurchaseRepository
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val purchaseRepository: PurchaseRepository
) {

    fun create(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)
    }
}
