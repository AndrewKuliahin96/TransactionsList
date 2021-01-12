package com.example.transactionslist.network.api

import com.example.transactionslist.network.response.TransactionsResponse
import retrofit2.http.GET

interface TransactionsApi {

    @GET("transactions/list/")
    suspend fun getTransactions(): TransactionsResponse?
}
