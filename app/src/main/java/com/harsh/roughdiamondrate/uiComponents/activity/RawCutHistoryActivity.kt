package com.harsh.roughdiamondrate.uiComponents.activity

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.harsh.roughdiamondrate.Utility
import com.harsh.roughdiamondrate.databinding.ActivityRawCutHistoryBinding
import com.harsh.roughdiamondrate.model.RawCutHistory
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


        /* binding.search.doAfterTextChanged {
             val temp: ArrayList<RawCutHistory> = ArrayList()
             for (d in rawCutHistoryList) {
                 //or use .equal(text) with you want equal match
                 //use .toLowerCase() for better matches
                 if (d.mainKatNumber!!.contains(it.toString())) {
                     temp.add(d)
                 }
             }
             adapter.search(temp)
         }*/



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

                binding.search.addTextChangedListener(object : TextWatcher {

                    override fun onTextChanged(
                        s: CharSequence?,
                        start: Int,
                        before: Int,
                        count: Int
                    ) {

                    }

                    override fun beforeTextChanged(
                        s: CharSequence?,
                        start: Int,
                        count: Int,
                        after: Int
                    ) {

                    }

                    override fun afterTextChanged(s: Editable) {

                        // filter your list from your input
                        val temp: ArrayList<RawCutHistory> = ArrayList()
                        if (s.toString().isNotEmpty()) {
                            for (d in it.rawCutHistory) {
                                if (d.mainKatNumber!!.contains(s.toString().trim())) {
                                    temp.add(d)
                                }
                            }
                            adapter.search(temp)
                        } else {
                            adapter.search(it.rawCutHistory)
                        }

                        //you can use runnable postDelayed like 500 ms to delay search text
                    }
                })

//                binding.search.addTextChangedListener { editText ->
//                    val temp: ArrayList<RawCutHistory> = ArrayList()
//                    if (editText.toString().isNotEmpty()) {
//                        for (d in it.rawCutHistory) {
//                            //or use .equal(text) with you want equal match
//                            //use .toLowerCase() for better matches
//                            if (d.mainKatNumber!!.contains(editText.toString().trim())) {
//                                temp.add(d)
//                            }
//                        }
//                        adapter.search(temp)
//                    }else{
//                        adapter.search(it.rawCutHistory)
//                    }
//
//                }
            } else {
                Utility.showToast(this, it.Message, Toast.LENGTH_LONG)
            }
        }

    }


}