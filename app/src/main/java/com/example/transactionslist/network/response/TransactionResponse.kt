package com.example.transactionslist.network.response

import org.joda.time.DateTime

data class TransactionResponse(
    val amount: Double?,
    val createdAt: DateTime?,
    val currency: String?,
    val recipient: String?
)
