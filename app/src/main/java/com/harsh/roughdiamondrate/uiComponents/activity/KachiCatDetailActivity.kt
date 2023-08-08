package com.harsh.roughdiamondrate.uiComponents.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.harsh.roughdiamondrate.R
import com.harsh.roughdiamondrate.databinding.ActivityKachiCatDetailBinding
import com.harsh.roughdiamondrate.databinding.ActivityTaiyarVeEnteryBinding

class KachiCatDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityKachiCatDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKachiCatDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}