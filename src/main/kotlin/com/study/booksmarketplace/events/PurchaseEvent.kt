package com.study.booksmarketplace.events

import com.study.booksmarketplace.model.PurchaseModel
import org.springframework.context.ApplicationEvent

class PurchaseEvent (
    source: Any,
    val purchaseModel: PurchaseModel
) : ApplicationEvent(source)