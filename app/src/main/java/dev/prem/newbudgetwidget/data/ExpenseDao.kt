package dev.prem.newbudgetwidget.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ExpenseDao {
    @Query("SELECT * FROM Expense")
    fun getAll(): List<Expense>

    @Query("SELECT * FROM Expense WHERE uid IN (:expenseIds)")
    fun loadAllByIds(expenseIds: IntArray): List<Expense>

    @Query("SELECT * FROM Expense WHERE uid IN (:id)")
    fun findById(id: Int): Expense

    @Query("SELECT * FROM Expense WHERE timestamp BETWEEN :startTime AND :endDate")
    fun findAllBetweenTimestamps(startTime: Long, endDate: Long): List<Expense>

    @Insert
    fun insertAll(vararg users: Expense)

    @Delete
    fun delete(user: Expense)
}