package com.example.adminforklore

import android.os.Bundle
import android.widget.Adapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adminforklore.adapter.DeliveryAdapter
import com.example.adminforklore.databinding.ActivityOutForActivityBinding

class OutForActivityActivity : AppCompatActivity() {
    private val binding: ActivityOutForActivityBinding by lazy {
        ActivityOutForActivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.backButton.setOnClickListener {
            finish()
        }

        val customerName = arrayListOf(
            "John Miller",
            "Jane Smith",
            "Lewis Hamilton",
            "Lando Norris"
        )

        val moneyStatus = arrayListOf(
            "Received",
            "Not Received",
            "Pending",
            "Not Received"
        )

        val adapter = DeliveryAdapter(customerName, moneyStatus)
        binding.DeliveryRecyclerView.adapter = adapter
        binding.DeliveryRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}