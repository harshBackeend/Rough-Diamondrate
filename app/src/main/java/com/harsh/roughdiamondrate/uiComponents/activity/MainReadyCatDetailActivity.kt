package com.harsh.roughdiamondrate.uiComponents.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.harsh.roughdiamondrate.R
import com.harsh.roughdiamondrate.databinding.ActivityMainReadyCatDetailBinding
import com.harsh.roughdiamondrate.viewModel.KachiCatDetailViewModel
import com.harsh.roughdiamondrate.viewModel.MainReadyKatViewModel

class MainReadyCatDetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainReadyCatDetailBinding
    lateinit var viewModel: MainReadyKatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainReadyCatDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainReadyKatViewModel::class.java]


        binding.buttonReset.setOnClickListener {
            binding.layoutMainData.visibility = View.GONE
            binding.buttonSend.visibility = View.VISIBLE
            binding.editDate.visibility = View.GONE
            binding.editCat.setText("")
        }

        binding.buttonSend.setOnClickListener {

        }

        binding.buttonSendEntry.setOnClickListener {

        }
    }
}