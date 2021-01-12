package com.example.transactionslist.network.response

import com.google.gson.annotations.SerializedName

data class TransactionsResponse(@SerializedName("transactions") val transactions: List<TransactionResponse>)
