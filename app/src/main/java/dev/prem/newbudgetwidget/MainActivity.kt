package dev.prem.newbudgetwidget

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dev.prem.newbudgetwidget.data.ExpenseViewModel
import dev.prem.newbudgetwidget.data.ExpenseViewModelFactory
import dev.prem.newbudgetwidget.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: ExpenseViewModel by viewModels {
        ExpenseViewModelFactory((application as ExpenseApplication).expenseDao)
    }

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

        viewModel.allExpenses.observe(this) { expenses ->
            (binding.expensesList.adapter as ExpenseListAdapter).submitList(expenses)
        }
    }

    fun getFloatingActionButton(): FloatingActionButton {
        return binding.fab
    }
}