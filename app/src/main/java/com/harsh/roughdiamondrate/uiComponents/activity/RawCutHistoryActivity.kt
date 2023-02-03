package com.harsh.roughdiamondrate.uiComponents.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.harsh.roughdiamondrate.databinding.ActivityRawCutHistoryBinding

class RawCutHistoryActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRawCutHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRawCutHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}