package com.harsh.roughdiamondrate.uiComponents.activity

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.harsh.roughdiamondrate.Utility
import com.harsh.roughdiamondrate.databinding.ActivityRawCutHistoryBinding
import com.harsh.roughdiamondrate.uiComponents.adapter.RawCutHistoryAdapter
import com.harsh.roughdiamondrate.uiComponents.commanUiView.ProgressBar
import com.harsh.roughdiamondrate.viewModel.RawCutHistoryViewModel

class RawCutHistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRawCutHistoryBinding
    private lateinit var viewModel: RawCutHistoryViewModel
    private lateinit var progressBar: Dialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRawCutHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[RawCutHistoryViewModel::class.java]

        binding.enterDetails.setOnClickListener {
            startActivity(Intent(this, RawCutDetailActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        progressBar = ProgressBar.getDialog(this)
        progressBar.setCancelable(false)
        progressBar.show()
        viewModel.getHistoryOfRawCut(this).observe(this) {
            progressBar.dismiss()
            if (it.Status == "1") {
                val adapter by lazy { RawCutHistoryAdapter(it.rawCutHistory, this) }
                binding.recyclerViewPartyHistory.layoutManager = LinearLayoutManager(this)
                binding.recyclerViewPartyHistory.adapter = adapter
            } else {
                Utility.showToast(this, it.Message, Toast.LENGTH_LONG)
            }
        }

    }


}