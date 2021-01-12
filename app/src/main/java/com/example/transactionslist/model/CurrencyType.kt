package com.example.transactionslist.model

import com.example.transactionslist.R

enum class CurrencyType(val type: String, val res: Int) {
    EUR("EUR", R.string.currency_eur),
    USD("USD", R.string.currency_usd),
    GBP("GBP", R.string.currency_gbd);

    companion object {
        fun byType(type: String?): CurrencyType? = values().firstOrNull { it.type == type }
    }
}
