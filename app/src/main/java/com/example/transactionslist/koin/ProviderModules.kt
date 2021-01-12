package com.example.transactionslist.koin

import com.example.transactionslist.network.converters.TransactionResponseConverter
import com.example.transactionslist.network.provider.TransactionsProvider
import org.koin.dsl.module

val providerModules = module {
    single { TransactionsProvider(get(), get()) }
}

val converterModules = module {
    single { TransactionResponseConverter() }
}