package dev.prem.newbudgetwidget.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Expense(
    @ColumnInfo(name = "amount") val amount: Float,
    @ColumnInfo(name = "description") val description: String?,
    @PrimaryKey @ColumnInfo(name = "timestamp") val timestamp: Long
)