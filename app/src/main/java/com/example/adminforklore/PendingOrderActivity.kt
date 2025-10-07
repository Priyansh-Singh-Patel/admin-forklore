package com.example.adminforklore

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adminforklore.adapter.DeliveryAdapter
import com.example.adminforklore.adapter.PendingOrderAdapter
import com.example.adminforklore.databinding.ActivityPendingOrderBinding
import com.example.adminforklore.databinding.PendingOrdersItemBinding

class PendingOrderActivity : AppCompatActivity() {

    private val binding: ActivityPendingOrderBinding by lazy {
        ActivityPendingOrderBinding.inflate(layoutInflater)
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

        val orderedCustomerName = arrayListOf(
            "John Miller",
            "Jane Smith",
            "Lewis Hamilton",
            "Lando Norris"
        )

        val orderedQuantity = arrayListOf(
            "5",
            "8",
            "10",
            "2"
        )

        val orderedFoodImages = arrayListOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4
        )

        val adapter = PendingOrderAdapter(orderedCustomerName, orderedQuantity, orderedFoodImages, this)
        binding.pendingOrderRecyclerView.adapter = adapter
        binding.pendingOrderRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}