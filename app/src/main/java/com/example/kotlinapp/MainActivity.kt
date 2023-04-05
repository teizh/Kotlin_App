package com.example.kotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ShareCompat.IntentReader
import com.example.kotlinapp.adapter.FlowerAdapter
import com.example.kotlinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: FlowerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fillRecyclerView()
    }

    private fun fillRecyclerView() {
        val arrayList: ArrayList<FlowerModel> = ArrayList()
        arrayList.add(FlowerModel("Ashley Red Rose Bouquet", 129, R.drawable.ashley_red_rose_bouquet))
        arrayList.add(FlowerModel("Isla White", 109, R.drawable.isla_white))
        arrayList.add(FlowerModel("Chandra Rose Mini Flower Box", 89, R.drawable.chandra_rose_mini_box))
        arrayList.add(FlowerModel("Blake Flower & Ferrero Chocolate", 209, R.drawable.blake_flower_ferrero_chocolate_gift))
        arrayList.add(FlowerModel("Jodie Phalaenopsis Orchid (3 stalks) ", 399, R.drawable.jodie_phalaenopsis_orchid))

        adapter = FlowerAdapter(arrayList) {flower ->
            println("${flower.name}")

            val intent= Intent(this, ContainerActivity::class.java)
            intent.putExtra("flower", flower)

            startActivity(intent)
        }
        binding.recyclerView.adapter = adapter
    }
}