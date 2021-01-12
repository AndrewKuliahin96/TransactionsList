package com.example.transactionslist.network.api

import com.example.transactionslist.network.response.BaseResponse
import com.example.transactionslist.network.response.TransactionResponse
import retrofit2.http.GET

interface TransactionsApi {

    @GET("transactions/list/")
    suspend fun getTransactions(): BaseResponse<List<TransactionResponse?>?>?
}
