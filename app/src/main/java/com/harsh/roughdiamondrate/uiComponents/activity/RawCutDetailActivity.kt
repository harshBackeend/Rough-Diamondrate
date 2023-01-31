package com.harsh.roughdiamondrate.uiComponents.activity

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View.OnFocusChangeListener
import android.widget.DatePicker
import androidx.lifecycle.MutableLiveData
import com.harsh.roughdiamondrate.Utility
import com.harsh.roughdiamondrate.databinding.ActivityRawCutDetailBinding
import java.util.*
import kotlin.collections.HashMap

class RawCutDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRawCutDetailBinding
    private lateinit var liveData: MutableLiveData<HashMap<String, Double>>

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRawCutDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        liveData = MutableLiveData<HashMap<String, Double>>()
        val hashMap = kotlin.collections.HashMap<String, Double>()

        hashMap["weight"] =0.00
        hashMap["price"] =0.00
        hashMap["dollarPrice"] =0.00

        binding.editDate.setOnClickListener {
            val c = Calendar.getInstance()
            val mYear = c[Calendar.YEAR]
            val mMonth = c[Calendar.MONTH]
            val mDay = c[Calendar.DAY_OF_MONTH]

            val datePickerDialog = DatePickerDialog(
                this, { _: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                    val day =
                        if (dayOfMonth > 9) dayOfMonth.toString() else "0$dayOfMonth"
                    val month =
                        if (monthOfYear + 1 > 9) (monthOfYear + 1).toString() else "0" + (monthOfYear + 1)
                    binding.editDate.setText("$day/$month/$year")
                }, mYear, mMonth, mDay
            )
            datePickerDialog.show()
        }

        binding.editDate.inputType = InputType.TYPE_NULL
        binding.editDate.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                Utility.hideKeyboard(this)
                binding.editDate.performClick()
            }
        }

        binding.weight.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                hashMap["weight"] = p0.toString().toDouble()
                liveData.postValue(hashMap)
            }
        })

        binding.price.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {

                hashMap["price"] = p0.toString().toDouble()

                liveData.postValue(hashMap)
            }
        })
        binding.dollarPrice.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {

                hashMap["dollarPrice"] = p0.toString().toDouble()

                liveData.postValue(hashMap)
            }
        })

        /*liveData.observe(this) {
            Utility.printLog("weight", it["weight"].toString())
            Utility.printLog("price", it["price"].toString())
        }*/
    }
}