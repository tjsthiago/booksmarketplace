package com.study.booksmarketplace.service

import com.study.booksmarketplace.events.PurchaseEvent
import com.study.booksmarketplace.model.PurchaseModel
import com.study.booksmarketplace.repository.PurchaseRepository
import jakarta.transaction.Transactional
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val purchaseRepository: PurchaseRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    @Transactional
    fun create(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)

        applicationEventPublisher.publishEvent(
            PurchaseEvent(
                this,
                purchaseModel
            )
        )
    }

    @Transactional
    fun update(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)
    }
}
