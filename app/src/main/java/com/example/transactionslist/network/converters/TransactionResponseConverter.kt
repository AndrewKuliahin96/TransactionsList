package com.example.transactionslist.network.converters

import com.example.transactionslist.model.CurrencyType
import com.example.transactionslist.model.TransactionModel
import com.example.transactionslist.network.response.TransactionResponse

class TransactionResponseConverter : BaseConverter<TransactionResponse, TransactionModel>() {

    override fun convert(response: TransactionResponse?): TransactionModel? = response?.run {
        TransactionModel(amount, createdAt, CurrencyType.byType(currency), recipient)
    }
}
