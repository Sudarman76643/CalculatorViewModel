package com.example.calculatorviewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calculatorviewmodel.databinding.ActivityMainBinding
import com.example.calculatorviewmodel.ui.CalculationAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: CalculationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // Inisialisasi RecyclerView
        adapter = CalculationAdapter(emptyList())
        binding.rvResults.layoutManager = LinearLayoutManager(this)
        binding.rvResults.adapter = adapter

        // Observe LiveData agar RecyclerView diperbarui
        viewModel.results.observe(this) {
            adapter = CalculationAdapter(it)
            binding.rvResults.adapter = adapter
        }

        binding.btncalculate.setOnClickListener {
            val width = binding.etWidth.text.toString()
            val height = binding.etHeight.text.toString()
            val length = binding.etLength.text.toString()

            when {
                width.isEmpty() -> binding.etWidth.error = "Field ini tidak boleh kosong"
                height.isEmpty() -> binding.etHeight.error = "Field ini tidak boleh kosong"
                length.isEmpty() -> binding.etLength.error = "Field ini tidak boleh kosong"
                else -> viewModel.calculate(width, height, length)
            }
        }
    }
}
