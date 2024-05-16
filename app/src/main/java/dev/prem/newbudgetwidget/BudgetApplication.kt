package dev.prem.newbudgetwidget

import android.app.Application
import androidx.room.Room
import dev.prem.newbudgetwidget.data.AppDatabase

class BudgetApplication : Application() {
    var db: AppDatabase? = null

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "budget-db"
        ).build()
    }
}