package dev.prem.newbudgetwidget

import android.app.Application
import dev.prem.newbudgetwidget.data.AppDatabase

class ExpenseApplication : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val expenseDao by lazy { database.expenseDao() }
}