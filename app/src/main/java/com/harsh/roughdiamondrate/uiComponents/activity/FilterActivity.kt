package com.harsh.roughdiamondrate.uiComponents.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.harsh.roughdiamondrate.databinding.ActivityFilterBinding
import com.harsh.roughdiamondrate.model.IntentKey
import com.harsh.roughdiamondrate.viewModel.FilterViewModel

class FilterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilterBinding
    private lateinit var viewModel: FilterViewModel
    private var partyName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent != null) {
            partyName = intent.getStringExtra(IntentKey.partyName)!!.toString()
        }




    }
}