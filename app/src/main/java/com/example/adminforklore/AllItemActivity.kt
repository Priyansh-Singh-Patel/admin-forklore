package com.example.adminforklore

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adminforklore.adapter.AddItemAdapter
import com.example.adminforklore.databinding.ActivityAllItemBinding

class AllItemActivity : AppCompatActivity() {

    private val binding: ActivityAllItemBinding by lazy {
        ActivityAllItemBinding.inflate(layoutInflater)
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

        val menuFoodName = listOf("Burger", "Pizza", "Samosa", "Chat", "Sandwich", "Momo")
        val menuItemPrice = listOf("₹50", "₹150", "₹10", "₹50", "₹50", "₹60")
        val menuImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu1
        )

        binding.backButton.setOnClickListener {
            finish()
        }

        val adapter = AddItemAdapter(ArrayList(menuFoodName), ArrayList(menuItemPrice), ArrayList(menuImage))
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.menuRecyclerView.adapter = adapter
    }
}