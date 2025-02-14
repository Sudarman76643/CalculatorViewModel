package com.example.calculatorviewmodel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.calculatorviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this@MainActivity).get(MainViewModel::class.java)

        displayResult()

        binding.btncalculate.setOnClickListener{
            val width = binding.etWidth.text.toString()
            val height = binding.etHeight.text.toString()
            val length = binding.etLength.text.toString()

            when {
                width.isEmpty() -> {
                    binding.etWidth.error = "Field ini tidak boleh kosong"
                }
                height.isEmpty() -> {
                    binding.etHeight.error = "Field ini tidak boleh kosong"
                }
                length.isEmpty() -> {
                    binding.etLength.error = "Field ini tidak boleh kosong"
                }
                else -> {
                   viewModel.calculate(width, height, length)
                    displayResult()
                }
            }
        }
    }

    private fun displayResult() {
        binding.result.text = viewModel.result.toString()

    }
}
