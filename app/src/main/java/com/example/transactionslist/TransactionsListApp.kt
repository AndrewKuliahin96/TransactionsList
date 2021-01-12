package com.example.transactionslist

import android.app.Application
import com.example.transactionslist.koin.*
import org.koin.core.context.startKoin

class TransactionsListApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(viewModelsModules, providerModules, networkModules, apiModules, converterModules))
        }
    }
}
