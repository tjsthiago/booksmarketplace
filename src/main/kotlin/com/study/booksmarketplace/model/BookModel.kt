package com.study.booksmarketplace.model

import com.study.booksmarketplace.exption.BadRequestException
import com.study.booksmarketplace.model.enums.BookStatus
import com.study.booksmarketplace.model.enums.Errors
import jakarta.persistence.*
import java.math.BigDecimal

@Entity(name = "book")
data class BookModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column
    var name: String,

    @Column
    var price: BigDecimal,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null
) {

    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null
        set(value) {
            if (field == BookStatus.CANCELLED || field == BookStatus.DELETED) {
                throw BadRequestException(
                    Errors.BOOK_UPDATE_NOT_ALLOWED.message.format(field),
                    Errors.BOOK_UPDATE_NOT_ALLOWED.code
                )
            }

            field = value
        }

    constructor(
        id: Long? = null,
        name: String,
        price: BigDecimal,
        customer: CustomerModel? = null,
        status: BookStatus?
    ) : this(id, name, price, customer) {
        this.status = status
    }

}