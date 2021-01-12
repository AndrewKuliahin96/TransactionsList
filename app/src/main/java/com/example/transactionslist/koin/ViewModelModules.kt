package com.example.transactionslist.koin

import com.example.transactionslist.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModules = module {
    viewModel { MainViewModel(get()) }
}
