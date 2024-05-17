package dev.prem.newbudgetwidget

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import dev.prem.newbudgetwidget.Constants.dateFormatter
import dev.prem.newbudgetwidget.data.Expense
import dev.prem.newbudgetwidget.data.ExpenseViewModel
import dev.prem.newbudgetwidget.data.ExpenseViewModelFactory
import dev.prem.newbudgetwidget.databinding.ActivityAddEditBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.ZoneId

class AddEditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddEditBinding
    var expense: Expense? = null

    private val viewModel: ExpenseViewModel by viewModels {
        ExpenseViewModelFactory((application as ExpenseApplication).expenseDao)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.saveButton.setOnClickListener {
            saveExpense()
        }

        binding.amountInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (0 == (s?.length ?: 0)) {
                    binding.saveButton.isEnabled = false
                } else {
                    binding.saveButton.isEnabled = true
                }
            }
        })
        populateUi()
    }

    private fun populateUi() {
        if (expense == null) {
            binding.toolbar.title = getString(R.string.add_expense)
            binding.saveButton.text = getString(R.string.add_expense)
            binding.todayDate.text = dateFormatter.format(LocalDateTime.now())
        } else {
            binding.toolbar.title = getString(R.string.update_expense)
            binding.saveButton.text = getString(R.string.update_expense)
        }
    }

    private fun saveExpense() {
        if (expense == null) {
            addNewExpense()
        } else {
            updateExpense()
        }
    }

    private fun addNewExpense() {
        expense = Expense(
            binding.amountInput.text.toString().toFloat(),
            binding.descriptionInput.text.toString(),
            LocalDateTime.parse(binding.todayDate.text.toString(), dateFormatter)
                .atZone(ZoneId.systemDefault()).toEpochSecond()
        )
        CoroutineScope(Dispatchers.IO).launch {
            // Access the database here
            viewModel.insert(expense!!)
            runOnUiThread {
                finish()
            }
        }
    }

    private fun updateExpense() {

    }
}