package com.example.transactionslist.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.transactionslist.model.TransactionModel
import com.example.transactionslist.network.provider.TransactionsProvider
import kotlinx.coroutines.launch

class MainViewModel(private val networkProvider: TransactionsProvider) : ViewModel() {

    val transactionsLiveData = MutableLiveData<List<TransactionModel?>>()

    fun getList() {
        viewModelScope.launch {
            networkProvider.getTransactions()?.let {
                transactionsLiveData.postValue(it)
            }
        }
    }
}
