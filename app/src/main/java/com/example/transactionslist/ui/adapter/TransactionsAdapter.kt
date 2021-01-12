package com.example.transactionslist.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.transactionslist.R
import com.example.transactionslist.model.TransactionModel

class TransactionsAdapter :
    ListAdapter<TransactionModel, TransactionsAdapter.TransactionViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TransactionModel>() {
            override fun areItemsTheSame(oldItem: TransactionModel, newItem: TransactionModel) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: TransactionModel, newItem: TransactionModel) =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_transaction, parent, false)

        return TransactionViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class TransactionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvRecipient = itemView.findViewById<TextView>(R.id.tvRecipient)
        private val tvAmount = itemView.findViewById<TextView>(R.id.tvAmount)
        private val tvTime = itemView.findViewById<TextView>(R.id.tvTime)

        fun bind(transaction: TransactionModel) {
            transaction.apply {
                tvRecipient.text = recipient

                currency?.res?.let {
                    tvAmount.text = itemView.context.getString(it, amount)
                }

                tvTime.text = createdAt?.toString("HH:mm")
            }
        }
    }
}
