package com.study.booksmarketplace.repository

import com.study.booksmarketplace.model.PurchaseModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PurchaseRepository: CrudRepository<PurchaseModel, Long>
