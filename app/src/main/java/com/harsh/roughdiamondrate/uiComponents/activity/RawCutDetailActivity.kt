package com.harsh.roughdiamondrate.uiComponents.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.harsh.roughdiamondrate.databinding.ActivityRawCutDetailBinding

class RawCutDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityRawCutDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRawCutDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}