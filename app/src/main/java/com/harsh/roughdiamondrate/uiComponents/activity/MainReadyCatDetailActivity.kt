package com.harsh.roughdiamondrate.uiComponents.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.harsh.roughdiamondrate.R
import com.harsh.roughdiamondrate.databinding.ActivityMainReadyCatDetailBinding

class MainReadyCatDetailActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainReadyCatDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainReadyCatDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}