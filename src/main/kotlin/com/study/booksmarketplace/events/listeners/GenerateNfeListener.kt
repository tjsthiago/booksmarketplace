package com.study.booksmarketplace.events.listeners

import com.study.booksmarketplace.events.PurchaseEvent
import com.study.booksmarketplace.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class GenerateNfeListener(
    private val purchaseService: PurchaseService
) {

    @EventListener
    fun listen(purchaseEvent: PurchaseEvent) {
        val nfe = UUID.randomUUID().toString()

        val purchaseModel = purchaseEvent.purchaseModel.copy(
            nfe = nfe
        )

        purchaseService.update(purchaseModel)
    }
}