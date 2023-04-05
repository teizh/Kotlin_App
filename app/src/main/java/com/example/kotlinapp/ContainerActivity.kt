package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ContainerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)

        val flowerModel: FlowerModel? = intent.getParcelableExtra("flower")
        val bundle = Bundle()

        bundle.putParcelable("flower", flowerModel)
        val detailFragment = DetailFragment()
        detailFragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_view, detailFragment).commit()

    }
}