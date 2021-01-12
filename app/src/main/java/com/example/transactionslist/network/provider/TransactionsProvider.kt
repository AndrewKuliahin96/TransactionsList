package com.example.transactionslist.network.provider

import com.example.transactionslist.model.TransactionModel
import com.example.transactionslist.network.api.TransactionsApi
import com.example.transactionslist.network.converters.TransactionResponseConverter

class TransactionsProvider(
    private val api: TransactionsApi,
    private val converter: TransactionResponseConverter
) {

    suspend fun getTransactions(): List<TransactionModel?>? {
        return api.getTransactions()?.transactions?.map { converter.convert(it) }
    }
}