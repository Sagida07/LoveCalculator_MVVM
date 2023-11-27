package com.example.lovecalculator_mvvm

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.lovecalculator_mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: LoveViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(binding.imgHeart)
            .load("https://i.pinimg.com/564x/09/56/17/0956174ddd8e5d3e92df648d8d338d13.jpg")
            .into(binding.imgHeart)

        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnCalculate.setOnClickListener {
                viewModel.getLiveLoveData(etFname.text.toString(), etSname.text.toString())
                    .observe(this@MainActivity, Observer {
                        tvTitle.text = it.toString()
                    })
            }
        }
    }
}