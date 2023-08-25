package com.harsh.roughdiamondrate.uiComponents.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.harsh.roughdiamondrate.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonMoney.setOnClickListener {
            startActivity(
                Intent(
                    this, ShowPartyList::class.java
                )
            )
        }

        binding.buttonRawCut.setOnClickListener {
            startActivity(
                Intent(
                    this, RawCutHistoryActivity::class.java
                )
            )
        }

        binding.buttonKatEntry.setOnClickListener {
            binding.layoutMenuHolder.visibility = View.GONE
            binding.layoutEntry.visibility = View.VISIBLE
        }

        binding.buttonReady.setOnClickListener {
            startActivity(
                Intent(
                    this, MainReadyCatDetailActivity::class.java
                )
            )
            binding.layoutMenuHolder.visibility = View.GONE
            binding.layoutEntry.visibility = View.VISIBLE
        }

        binding.buttonRawCutDetail.setOnClickListener {
            startActivity(
                Intent(
                    this, KachiCatDetailActivity::class.java
                )
            )
            binding.layoutMenuHolder.visibility = View.GONE
            binding.layoutEntry.visibility = View.VISIBLE
        }

        binding.buttonReadyToSell.setOnClickListener {
            startActivity(
                Intent(
                    this, TaiyarVeListingActivity::class.java
                )
            )
        }

    }
}