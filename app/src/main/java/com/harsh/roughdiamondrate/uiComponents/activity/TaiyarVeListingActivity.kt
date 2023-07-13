package com.harsh.roughdiamondrate.uiComponents.activity

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.harsh.roughdiamondrate.Utility
import com.harsh.roughdiamondrate.databinding.ActivityTaiyarVeListingBinding
import com.harsh.roughdiamondrate.model.TaiyarVeList
import com.harsh.roughdiamondrate.uiComponents.adapter.TaiyarVeListingAdapter
import com.harsh.roughdiamondrate.uiComponents.commanUiView.ProgressBar
import com.harsh.roughdiamondrate.viewModel.TaiyarVeListViewModel

class TaiyarVeListingActivity : AppCompatActivity() {

    lateinit var binding:ActivityTaiyarVeListingBinding
    private lateinit var viewModel: TaiyarVeListViewModel
    private lateinit var progressBar: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaiyarVeListingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[TaiyarVeListViewModel::class.java]

        binding.enterDetails.setOnClickListener {
            startActivity(Intent(this,TaiyarVeEnteryActivity::class.java))
        }

    }

    override fun onStart() {
        super.onStart()
        progressBar = ProgressBar.getDialog(this)
        progressBar.setCancelable(false)
        progressBar.show()
        viewModel.getTaiyarVeList(this).observe(this) {
            progressBar.dismiss()
            if (it.Status == "1") {
                val adapter by lazy { TaiyarVeListingAdapter(it.taiyarVeList, this) }
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
                        val temp: ArrayList<TaiyarVeList> = ArrayList()
                        if (s.toString().isNotEmpty()) {
                            for (d in it.taiyarVeList) {
                                if (d.no!!.contains(s.toString().trim())) {
                                    temp.add(d)
                                }
                            }
                            adapter.search(temp)
                        } else {
                            adapter.search(it.taiyarVeList)
                        }

                        //you can use runnable postDelayed like 500 ms to delay search text
                    }
                })

            } else {
                Utility.showToast(this, it.Message, Toast.LENGTH_LONG)
            }
        }
    }
}