package com.example.transactionslist.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.transactionslist.R
import com.example.transactionslist.ui.adapter.TransactionsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()

    private val adapter by lazy { TransactionsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initList()
        observeViewModel()
        viewModel.getList()
    }

    private fun initList() {
        rvTransactions.adapter = this@MainActivity.adapter
    }

    private fun observeViewModel() {
        viewModel.apply {
            transactionsLiveData.observe(this@MainActivity) {
                adapter.submitList(it)
            }
        }
    }
}
