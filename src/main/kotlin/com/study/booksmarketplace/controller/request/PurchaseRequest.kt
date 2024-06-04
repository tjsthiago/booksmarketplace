package com.study.booksmarketplace.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import jakarta.annotation.Nonnull
import jakarta.validation.constraints.Positive

data class PurchaseRequest(
    @field:Nonnull
    @field:Positive
    val customerId: Long,

    @field:Nonnull
    @JsonAlias("book_ids")
    val bookIds: Set<Long>
)