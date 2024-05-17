package dev.prem.newbudgetwidget

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dev.prem.newbudgetwidget.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener {
            val addIntent = Intent(this, AddEditActivity::class.java)
            startActivity(addIntent)
        }

        binding.expensesList.adapter = ExpenseListAdapter()
        binding.expensesList.layoutManager = LinearLayoutManager(this)
    }

    fun getFloatingActionButton(): FloatingActionButton {
        return binding.fab
    }
}