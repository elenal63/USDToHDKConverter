package com.example.usdtohkd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.usdtohkd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater )
        setContentView(binding.root)

        binding.dollarPicker.minValue = 0
        binding.dollarPicker.maxValue = 100000

        binding.centPicker.minValue = 0
        binding.centPicker.maxValue = 100

        binding.centPicker.setOnValueChangedListener{ _,_,_ ->
            convertDollars()
        }

        binding.dollarPicker.setOnValueChangedListener{ _,_,_ ->
            convertDollars()
        }

    }

    private fun convertDollars(){
        var dollars = binding.dollarPicker.value
        var cents = binding.centPicker.value
        var centsDecimal = cents * .01

        var total = dollars.toDouble() + centsDecimal.toDouble()
        var hkd = total * 7.82

        binding.resultsTV.text = String.format("Hong Kong Dollars: %.2f", hkd)


    }
}