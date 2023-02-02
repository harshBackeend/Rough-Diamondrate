package com.harsh.roughdiamondrate.uiComponents.activity

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View.OnFocusChangeListener
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.harsh.roughdiamondrate.Utility
import com.harsh.roughdiamondrate.databinding.ActivityRawCutDetailBinding
import java.util.*
import kotlin.math.roundToInt

class RawCutDetailActivity : AppCompatActivity() {
    /**
     * This use for bind xml file to java file.
     */
    private lateinit var binding: ActivityRawCutDetailBinding

    /**
     * This use for live calculation in this activity.
     */
    private lateinit var liveData: MutableLiveData<HashMap<String, Double>>

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRawCutDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        liveData = MutableLiveData<HashMap<String, Double>>()
        val hashMap = kotlin.collections.HashMap<String, Double>()

        hashMap["weight"] = 0.00
        hashMap["price"] = 0.00
        hashMap["dollarPrice"] = 0.00
        hashMap["brokeragePrice"] = 0.00
        hashMap["sellingPrice"] = 0.00
        hashMap["numberWeight"] = 0.00
        hashMap["numberPrice"] = 0.00
        hashMap["numberTotalPrice"] = 0.00

        binding.editDate.setOnClickListener {
            val c = Calendar.getInstance()
            val mYear = c[Calendar.YEAR]
            val mMonth = c[Calendar.MONTH]
            val mDay = c[Calendar.DAY_OF_MONTH]

            val datePickerDialog = DatePickerDialog(
                this, { _: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                    val day = if (dayOfMonth > 9) dayOfMonth.toString() else "0$dayOfMonth"
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

        binding.layoutDate.setOnClickListener {
            binding.editDate.performClick()
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

        binding.brokeragePrice.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {

                hashMap["brokeragePrice"] = p0.toString().toDouble()

                liveData.postValue(hashMap)
            }
        })

        binding.numberWeight.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {

                hashMap["numberWeight"] = p0.toString().toDouble()

                liveData.postValue(hashMap)
            }
        })

        binding.numberPrice.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {

                hashMap["numberPrice"] = p0.toString().toDouble()

                liveData.postValue(hashMap)
            }
        })

        liveData.observe(this) {
            val constant = 100
            var secondSum = 0.00
            if (it["brokeragePrice"]!! > 0.00) {
                secondSum =
                    it["weight"]!! * it["price"]!! * it["dollarPrice"]!! * (it["brokeragePrice"]!! / constant)
            }
            if (secondSum > 0.00) {
                hashMap["sellingPrice"] =
                    it["weight"]!! * it["price"]!! * it["dollarPrice"]!! + secondSum.roundToInt()
                binding.sellingPrice.setText("${(it["weight"]!! * it["price"]!! * it["dollarPrice"]!! + secondSum).roundToInt()}")
            }

            if (it["weight"]!! > 0.00) {
                binding.totalPrice.setText("${(it["sellingPrice"]!! / it["weight"]!!).roundToInt()}")
                binding.numberPercentage.setText("${(it["numberWeight"]!! / (it["weight"]!! / constant)).roundToInt()}")
            }

            if (it["numberWeight"]!! > 0 && it["numberPrice"]!! > 0) {
                hashMap["numberTotalPrice"] = it["numberWeight"]!! * it["numberPrice"]!!
                binding.numberTotalPrice.setText("${(it["numberWeight"]!! * it["numberPrice"]!!).roundToInt()}")
            }

            if (it["weight"]!! > it["numberWeight"]!!) {
                binding.finalPrice.setText("${((it["sellingPrice"]!! - it["numberTotalPrice"]!!) / (it["weight"]!! - it["numberWeight"]!!)).roundToInt()}")
            }
        }
    }

}