package com.example.transactionslist.koin

import com.example.transactionslist.network.api.TransactionsApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModules = module {
    single<Retrofit> { getRetrofit(get()) }
}

val apiModules = module {
    single<TransactionsApi> { getTransactionsApi(get()) }
}

private fun getRetrofit(client: OkHttpClient) = Retrofit.Builder()
    .baseUrl("https://meatotopcreator.herokuapp.com/")
    .client(client)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

private fun getTransactionsApi(retrofit: Retrofit) = retrofit.create(TransactionsApi::class.java)
