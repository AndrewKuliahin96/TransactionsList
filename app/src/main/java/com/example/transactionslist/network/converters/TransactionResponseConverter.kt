package com.example.transactionslist.network.converters

import com.example.transactionslist.model.CurrencyType
import com.example.transactionslist.model.TransactionModel
import com.example.transactionslist.network.response.TransactionResponse
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

class TransactionResponseConverter : BaseConverter<TransactionResponse, TransactionModel>() {

    override fun convert(response: TransactionResponse?): TransactionModel? = response?.run {
        TransactionModel(
            amount,
            createdAt?.let { convertStringToDateTime(it) },
            CurrencyType.byType(currency),
            recipient
        )
    }

    private fun convertStringToDateTime(createdAt: String): DateTime? =
        DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime(createdAt)
}
