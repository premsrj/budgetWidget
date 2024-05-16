package dev.prem.newbudgetwidget

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dev.prem.newbudgetwidget.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener {
            val addIntent = Intent(this, AddEditActivity::class.java)
            startActivity(addIntent)
        }
    }

    fun getFloatingActionButton(): FloatingActionButton {
        return binding.fab
    }

//    override fun onResume() {
//        super.onResume()
//        binding.toolbar.title = "Monthly Budget"
//    }
}