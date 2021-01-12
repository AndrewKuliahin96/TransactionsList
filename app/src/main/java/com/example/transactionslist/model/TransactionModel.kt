package com.example.transactionslist.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.joda.time.DateTime

@Parcelize
data class TransactionModel(
    val amount: Double?,
    val createdAt: DateTime?,
    val currency: CurrencyType?,
    val recipient: String?
) : Parcelable {
    val id: Long = hashCode().toLong()
}
