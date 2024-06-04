package com.study.booksmarketplace.controller.request

import jakarta.annotation.Nonnull
import jakarta.validation.constraints.Positive

data class PurchaseRequest(
    @field:Nonnull
    @field:Positive
    val customerId: Long,

    @field:Nonnull
    val bookIds: Set<Long>
)