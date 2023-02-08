package com.harsh.roughdiamondrate.uiComponents.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.Log
import android.view.View.OnFocusChangeListener
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.harsh.roughdiamondrate.Utility
import com.harsh.roughdiamondrate.databinding.ActivityRawCutDetailBinding
import com.harsh.roughdiamondrate.model.IntentKey
import com.harsh.roughdiamondrate.model.RawCutHistory
import com.harsh.roughdiamondrate.model.ValidationModel
import com.harsh.roughdiamondrate.uiComponents.commanUiView.ProgressBar
import com.harsh.roughdiamondrate.viewModel.RawCutDetailViewModel
import java.io.Serializable
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
    private lateinit var progressBar: Dialog
    lateinit var viewModel: RawCutDetailViewModel


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRawCutDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[RawCutDetailViewModel::class.java]
        liveData = MutableLiveData<HashMap<String, Double>>()
        val hashMap = kotlin.collections.HashMap<String, Double>()

        getTextFromIntent()

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
                try {
                    if (p0!!.toString() == ".") {
                        binding.weight.setText("0.")
                        binding.weight.setSelection(Utility.getTextFromEditText(binding.weight).length)
                    } else {
                        if (p0.isNotEmpty()) {
                            hashMap["weight"] = p0.toString().toDouble()
                            liveData.postValue(hashMap)
                        }
                    }
                } catch (e: Exception) {
                    Utility.printLog("weight", "$p0 ${e.message}")
                }
            }
        })

        binding.price.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                try {
                    if (p0!!.toString() == ".") {
                        binding.price.setText("0.")
                        binding.price.setSelection(Utility.getTextFromEditText(binding.price).length)
                    } else {
                        if (p0.isNotEmpty()) {
                            hashMap["price"] = p0.toString().toDouble()
                            liveData.postValue(hashMap)
                        }
                    }
                } catch (e: Exception) {
                    Utility.printLog("price", "$p0 ${e.message}")

                }

            }
        })

        binding.dollarPrice.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                try {
                    if (p0!!.toString() == ".") {
                        binding.dollarPrice.setText("0.")
                        binding.dollarPrice.setSelection(Utility.getTextFromEditText(binding.dollarPrice).length)
                    } else {
                        if (p0.isNotEmpty()) {
                            hashMap["dollarPrice"] = p0.toString().toDouble()
                            liveData.postValue(hashMap)
                        }
                    }
                } catch (e: Exception) {
                    Utility.printLog("dollarPrice", "$p0 ${e.message}")
                }

            }
        })

        binding.brokeragePrice.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                try {
                    if (p0!!.toString() == ".") {
                        binding.brokeragePrice.setText("0.")
                        binding.brokeragePrice.setSelection(Utility.getTextFromEditText(binding.brokeragePrice).length)
                    } else {
                        if (p0.isNotEmpty()) {
                            hashMap["brokeragePrice"] = p0.toString().toDouble()
                            liveData.postValue(hashMap)
                        }
                    }
                } catch (e: Exception) {
                    Utility.printLog("brokeragePrice", "$p0 ${e.message}")

                }


            }
        })

        binding.numberWeight.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                try {
                    if (p0!!.toString() == ".") {
                        binding.numberWeight.setText("0.")
                        binding.numberWeight.setSelection(Utility.getTextFromEditText(binding.numberWeight).length)
                    } else {
                        if (p0.isNotEmpty()) {
                            hashMap["numberWeight"] = p0.toString().toDouble()
                            liveData.postValue(hashMap)
                        }
                    }
                } catch (e: Exception) {
                    Utility.printLog("numberWeight", "$p0 ${e.message}")
                }


            }
        })

        binding.numberPrice.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                try {
                    if (p0!!.toString() == ".") {
                        binding.numberPrice.setText("0.")
                        binding.numberPrice.setSelection(Utility.getTextFromEditText(binding.numberPrice).length)
                    } else {
                        if (p0.isNotEmpty()) {
                            hashMap["numberPrice"] = p0.toString().toDouble()
                            liveData.postValue(hashMap)
                        }
                    }
                } catch (e: Exception) {
                    Utility.printLog("numberPrice", "$p0 ${e.message}")
                }

            }
        })
        /*binding.sellingPrice.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                try {
                    if (p0!!.toString() == ".") {
                        binding.sellingPrice.setText("0.")
                        binding.sellingPrice.setSelection(Utility.getTextFromEditText(binding.sellingPrice).length)
                    } else {
                        if (p0.isNotEmpty()) {
                            hashMap["sellingPrice"] = p0.toString().toDouble()
                            liveData.postValue(hashMap)
                        }
                    }
                } catch (e: Exception) {
                    Utility.printLog("sellingPrice", "$p0 ${e.message}")
                }

            }
        })*/
        /*binding.numberTotalPrice.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                try {
                    if (p0!!.toString() == ".") {
                        binding.numberTotalPrice.setText("0.")
                        binding.numberTotalPrice.setSelection(Utility.getTextFromEditText(binding.numberTotalPrice).length)
                    } else {
                        if (p0.isNotEmpty()) {
                            hashMap["numberTotalPrice"] = p0.toString().toDouble()
                            liveData.postValue(hashMap)
                        }
                    }
                } catch (e: Exception) {
                    Utility.printLog("numberTotalPrice", "$p0 ${e.message}")
                }

            }
        })*/

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
                binding.numberPercentage.setText("${(it["numberWeight"]!! / (it["weight"]!! / constant)).toFloat()}")
            }

            if (it["numberWeight"]!! > 0 && it["numberPrice"]!! > 0) {
                hashMap["numberTotalPrice"] = it["numberWeight"]!! * it["numberPrice"]!!
                binding.numberTotalPrice.setText("${(it["numberWeight"]!! * it["numberPrice"]!!).roundToInt()}")
            }

            if (it["weight"]!! > it["numberWeight"]!!) {
                binding.finalPrice.setText("${((it["sellingPrice"]!! - it["numberTotalPrice"]!!) / (it["weight"]!! - it["numberWeight"]!!)).roundToInt()}")
            }
        }

        binding.buttonSend.setOnClickListener {
            progressBar = ProgressBar.getDialog(this)
            progressBar.setCancelable(false)
            progressBar.show()
            binding.buttonSend.isEnabled = false
            viewModel.setDataToApi(
                Utility.getTextFromEditText(binding.editDate),
                Utility.getTextFromEditText(binding.mainKatNumber),
                Utility.getTextFromEditText(binding.no),
                Utility.getTextFromEditText(binding.katName),
                Utility.getTextFromEditText(binding.maineWeight),
                Utility.getTextFromEditText(binding.bag),
                Utility.getTextFromEditText(binding.weight),
                Utility.getTextFromEditText(binding.price),
                Utility.getTextFromEditText(binding.dollarPrice),
                Utility.getTextFromEditText(binding.brokeragePrice),
                Utility.getTextFromEditText(binding.sellingPrice),
                Utility.getTextFromEditText(binding.totalPrice),
                Utility.getTextFromEditText(binding.numberWeight),
                Utility.getTextFromEditText(binding.numberPrice),
                Utility.getTextFromEditText(binding.numberPercentage),
                Utility.getTextFromEditText(binding.numberTotalPrice),
                Utility.getTextFromEditText(binding.finalPrice),
                Utility.getTextFromEditText(binding.editDetail),
                this
            ).observe(this) {
                Log.e("TAG", "onCreate: $it")
                Toast.makeText(this, it.Message, Toast.LENGTH_LONG).show()
                if (it.Status == "1") {
                    progressBar.dismiss()
                    binding.buttonSend.isEnabled = true
                    Utility.resetEditText(binding.editDate)
                    Utility.resetEditText(binding.mainKatNumber)
                    Utility.resetEditText(binding.no)
                    Utility.resetEditText(binding.katName)
                    Utility.resetEditText(binding.maineWeight)
                    Utility.resetEditText(binding.bag)
                    Utility.resetEditText(binding.weight)
                    Utility.resetEditText(binding.price)
                    Utility.resetEditText(binding.dollarPrice)
                    Utility.resetEditText(binding.brokeragePrice)
                    Utility.resetEditText(binding.sellingPrice)
                    Utility.resetEditText(binding.totalPrice)
                    Utility.resetEditText(binding.numberWeight)
                    Utility.resetEditText(binding.numberPrice)
                    Utility.resetEditText(binding.numberPercentage)
                    Utility.resetEditText(binding.numberTotalPrice)
                    Utility.resetEditText(binding.finalPrice)
                    Utility.resetEditText(binding.editDetail)
                    finish()
                } else {
                    progressBar.dismiss()
                    Toast.makeText(this, it.Message, Toast.LENGTH_LONG).show()
                }
            }

        }
    }

    private fun getTextFromIntent() {
        try {
            if (intent != null) {
                val bundle = intent.getBundleExtra(IntentKey.bundle)
                val model = bundle!!.serializable<RawCutHistory>(IntentKey.rawCutDetail)

                if (model != null) {

                }

            }

        } catch (e: java.lang.Exception) {
            Utility.printLog("Error", "${e.message}")
        }
    }

    inline fun <reified T : Serializable> Bundle.serializable(key: String): T? = when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> getSerializable(key, T::class.java)
        else ->  getSerializable(key) as? T
    }
    fun <T : Serializable?> getSerializable(activity: Activity, name: String, clazz: Class<T>): T
    {
        return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            activity.intent.getSerializableExtra(name, clazz)!!
        else
            activity.intent.getSerializableExtra(name) as T
    }
}