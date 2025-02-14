package com.example.calculatorviewmodel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculatorviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
                    val volume = width.toDouble() * height.toDouble() * length.toDouble()
                    binding.result.text = volume.toString()
                }
            }
        }
    }
}
