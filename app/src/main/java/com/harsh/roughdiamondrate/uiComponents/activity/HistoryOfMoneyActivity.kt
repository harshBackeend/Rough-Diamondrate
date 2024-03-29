package com.harsh.roughdiamondrate.uiComponents.activity

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.harsh.roughdiamondrate.Utility
import com.harsh.roughdiamondrate.databinding.ActivityHistoryOfMoneyBinding
import com.harsh.roughdiamondrate.model.IntentKey
import com.harsh.roughdiamondrate.uiComponents.adapter.HistoryAdapter
import com.harsh.roughdiamondrate.uiComponents.commanUiView.ProgressBar
import com.harsh.roughdiamondrate.viewModel.HistoryOfMoneyViewModel

class HistoryOfMoneyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryOfMoneyBinding
    private lateinit var viewModel: HistoryOfMoneyViewModel
    private var partyName = ""
    lateinit var progressBar: Dialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryOfMoneyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[HistoryOfMoneyViewModel::class.java]

        if (intent != null) {
            partyName = intent.getStringExtra(IntentKey.partyName)!!.toString()
        }

        binding.enterDetails.setOnClickListener {
            if (partyName.isNotEmpty()) {
                val intent = Intent(this, AddMoneyDetailActivity::class.java)
                intent.putExtra(IntentKey.partyName, partyName)
                startActivity(intent)
            }

        }
    }

    override fun onStart() {
        super.onStart()
        progressBar = ProgressBar.getDialog(this)
        progressBar.setCancelable(false)
        progressBar.show()
        viewModel.getHistory(this, partyName).observe(this) {
            progressBar.dismiss()
            if (it.Status == "1") {
                binding.totalPayment.text = it.totalAmount
                val adapter by lazy { HistoryAdapter(it.data) }
                binding.recyclerViewPartyHistory.layoutManager = LinearLayoutManager(this)
                binding.recyclerViewPartyHistory.adapter = adapter
            } else {
                binding.totalPayment.text = "0"
                Utility.showToast(this, it.Message, Toast.LENGTH_LONG)
            }
        }
    }

}