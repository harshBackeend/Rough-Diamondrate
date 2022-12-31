package com.harsh.roughdiamondrate.uiComponents.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.harsh.roughdiamondrate.databinding.ActivityShowPartyListBinding

class ShowPartyList : AppCompatActivity() {

    lateinit var binding: ActivityShowPartyListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowPartyListBinding.inflate(layoutInflater);
        setContentView(binding.root)
    }
}