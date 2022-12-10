package com.harsh.roughdiamondrate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.harsh.roughdiamondrate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonGetRate.setOnClickListener {
            val rate = getRate()
            if(rate > 0){
                if(binding.layoutPolishReport.visibility == View.GONE){
                    binding.layoutPolishReport.visibility = View.VISIBLE
                    binding.textPolishReport.text = rate.toString()
                }
            }
        }
        binding.buttonReset.setOnClickListener {
            binding.editRFPrice.text = null
            binding.editRFTaka.text = null
            binding.editDiamondSize.text = null
            binding.editDiamondMajuri.text = null
            binding.editDiamondPolishResult.text = null
            binding.editProfitInPercentage.text = null
        }
    }
    private fun getRate():Float {

        val editRFPrice: Float? = binding.editRFPrice.text.toString().trim().toFloatOrNull()
        val editRFTaka: Float? = binding.editRFTaka.text.toString().trim().toFloatOrNull()
        val editDiamondSize: Float? = binding.editDiamondSize.text.toString().trim().toFloatOrNull()
        val editDiamondMajuri: Float? =
            binding.editDiamondMajuri.text.toString().trim().toFloatOrNull()
        val editDiamondPolishResult: Float? =
            binding.editDiamondPolishResult.text.toString().trim().toFloatOrNull()
        val editProfitInPercentage: Float? =
            binding.editProfitInPercentage.text.toString().trim().toFloatOrNull()
        val constant = 100

        val result: Float = (((editRFPrice!! / (editRFTaka!! / constant)) + (editDiamondMajuri!! * editDiamondSize!!)) / (editDiamondPolishResult!! / constant))

        return result
    }
}