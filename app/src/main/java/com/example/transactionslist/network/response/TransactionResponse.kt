package com.example.transactionslist.network.response

import com.google.gson.annotations.SerializedName

data class TransactionResponse(
    @SerializedName("amount") val amount: Double?,
    @SerializedName("createdAt") val createdAt: String?,
    @SerializedName("currency") val currency: String?,
    @SerializedName("recipient") val recipient: String?
)
