package com.harsh.roughdiamondrate.uiComponents.activity

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.harsh.roughdiamondrate.databinding.ActivityShowPartyListBinding
import com.harsh.roughdiamondrate.uiComponents.adapter.PartyListAdapter
import com.harsh.roughdiamondrate.uiComponents.commanUiView.ProgressBar
import com.harsh.roughdiamondrate.viewModel.ShowPartyListViewModel

class ShowPartyList : AppCompatActivity() {

    lateinit var binding: ActivityShowPartyListBinding
    lateinit var viewModel: ShowPartyListViewModel
    lateinit var progressBar: Dialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowPartyListBinding.inflate(layoutInflater);
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[ShowPartyListViewModel::class.java]


    }

    override fun onStart() {
        super.onStart()
        progressBar = ProgressBar.getDialog(this)
        progressBar.setCancelable(false)
        progressBar.show()
        viewModel.getPartyList(this).observe(this) {
            if (it.Status == "1") {
                progressBar.dismiss()
                val adapter by lazy { PartyListAdapter(it.data, this) }
                binding.recyclerViewPartyLis.layoutManager = LinearLayoutManager(this)
                binding.recyclerViewPartyLis.adapter = adapter
            } else {
                progressBar.dismiss()
                Toast.makeText(this, it.Message, Toast.LENGTH_LONG).show()
            }
        }

    }
}