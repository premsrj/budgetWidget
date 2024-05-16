package dev.prem.newbudgetwidget.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Expense(
    @PrimaryKey
    val uid: Int,
    @ColumnInfo(name = "amount") val amount: Int,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "timestamp") val timestamp: Long
)