package dev.prem.newbudgetwidget

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.prem.newbudgetwidget.Constants.simpleDateFormat
import dev.prem.newbudgetwidget.data.Expense
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.Date


class ExpenseListAdapter :
    ListAdapter<Expense, ExpenseListAdapter.ExpenseViewHolder>(ExpenseComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        return ExpenseViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dateTextView: TextView = itemView.findViewById(R.id.dateText)
        private val amountTextView: TextView = itemView.findViewById(R.id.amountText)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionText)
        fun bind(expense: Expense) {
            Instant.ofEpochMilli(expense.timestamp)
            val date = Date(expense.timestamp * 1000)
            val dateTime = LocalDateTime.ofEpochSecond(expense.timestamp, 0, ZoneOffset.UTC)
            dateTextView.text = simpleDateFormat.format(date)
            amountTextView.text = String.format(
                amountTextView.context.getString(R.string.amount_string),
                expense.amount
            )
            descriptionTextView.text = expense.description ?: ""
        }

        companion object {

            fun create(parent: ViewGroup): ExpenseViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.expense_recycler_item, parent, false)
                return ExpenseViewHolder(view)
            }
        }
    }

    class ExpenseComparator : DiffUtil.ItemCallback<Expense>() {
        override fun areItemsTheSame(oldItem: Expense, newItem: Expense): Boolean {
            return oldItem.timestamp == newItem.timestamp
        }

        override fun areContentsTheSame(oldItem: Expense, newItem: Expense): Boolean {
            return oldItem.equals(newItem)
        }
    }
}