package com.example.transactionslist.koin

import com.example.transactionslist.network.converters.TransactionResponseConverter
import org.koin.dsl.module

val converterModules = module {
    TransactionResponseConverter()
}