package dev.prem.newbudgetwidget.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {
    @Query("SELECT * FROM Expense")
    fun getAll(): Flow<List<Expense>>

    @Query("SELECT * FROM Expense WHERE timestamp IN (:timestamp)")
    fun findByTimestamp(timestamp: Long): Expense

    @Query("SELECT * FROM Expense WHERE timestamp BETWEEN :startTime AND :endDate")
    fun findAllBetweenTimestamps(startTime: Long, endDate: Long): Flow<List<Expense>>

    @Insert
    fun insertAll(vararg users: Expense)

    @Delete
    fun delete(user: Expense)
}