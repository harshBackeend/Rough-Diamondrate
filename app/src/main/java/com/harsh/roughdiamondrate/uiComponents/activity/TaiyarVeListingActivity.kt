package com.harsh.roughdiamondrate.uiComponents.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.harsh.roughdiamondrate.databinding.ActivityTaiyarVeListingBinding

class TaiyarVeListingActivity : AppCompatActivity() {
    lateinit var binding:ActivityTaiyarVeListingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaiyarVeListingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}