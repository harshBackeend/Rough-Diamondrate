package com.harsh.roughdiamondrate.uiComponents.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.harsh.roughdiamondrate.databinding.ActivityKatEntryMenuBinding

class KatEntryMenuActivity : AppCompatActivity() {

    lateinit var binding: ActivityKatEntryMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKatEntryMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonMainRowKat.setOnClickListener {
            startActivity(Intent(this, KachiCatDetailActivity::class.java))
        }

        binding.buttonMainReadyKat.setOnClickListener {
            startActivity(Intent(this, MainReadyCatDetailActivity::class.java))
        }


    }
}