package com.example.transactionslist.koin

import com.example.transactionslist.network.api.TransactionsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModules = module {
    single<Retrofit> { getRetrofit(get()) }
    single { getOkHttpClient() }
}

val apiModules = module {
    single<TransactionsApi> { getTransactionsApi(get()) }
}

private fun getRetrofit(client: OkHttpClient) = Retrofit.Builder()
    .baseUrl("http://meatotopcreator.herokuapp.com/")
    .client(client)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

private fun getOkHttpClient() = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
    .addInterceptor {
        it.proceed(it.request().newBuilder().header("Content-Type", "application/json").build())
    }
    .writeTimeout(10L, TimeUnit.SECONDS)
    .readTimeout(10L, TimeUnit.SECONDS)
    .build()

private fun getTransactionsApi(retrofit: Retrofit) = retrofit.create(TransactionsApi::class.java)
