package com.harsh.roughdiamondrate.uiComponents.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.harsh.roughdiamondrate.R
import com.harsh.roughdiamondrate.databinding.ActivityKachiCatDetailBinding
import com.harsh.roughdiamondrate.databinding.ActivityTaiyarVeEnteryBinding
import com.harsh.roughdiamondrate.viewModel.KachiCatDetailViewModel

class KachiCatDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityKachiCatDetailBinding
    lateinit var viewModel: KachiCatDetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKachiCatDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[KachiCatDetailViewModel::class.java]

        binding.buttonReset.setOnClickListener {
            binding.layoutData.visibility = View.GONE
            binding.editDate.visibility = View.GONE
            binding.buttonSend.visibility = View.VISIBLE
            binding.editCat.setText("")
        }

        binding.buttonSendEntry.setOnClickListener {

        }
        binding.buttonSend.setOnClickListener {

        }
    }
}