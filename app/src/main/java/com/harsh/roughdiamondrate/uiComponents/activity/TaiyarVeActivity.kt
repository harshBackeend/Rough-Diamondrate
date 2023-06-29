package com.harsh.roughdiamondrate.uiComponents.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.harsh.roughdiamondrate.R
import com.harsh.roughdiamondrate.databinding.ActivityTaiyarVeBinding

class TaiyarVeActivity : AppCompatActivity() {
    lateinit var binding:ActivityTaiyarVeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaiyarVeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}