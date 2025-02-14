package com.example.calculatorviewmodel.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calculatorviewmodel.databinding.ItemCalculationBinding
import com.example.calculatorviewmodel.modelData.CalculationResult

class CalculationAdapter(private val items: List<CalculationResult>) :
    RecyclerView.Adapter<CalculationAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemCalculationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CalculationResult) {
            binding.tvResult.text =
                "W: ${item.width}, H: ${item.height}, L: ${item.length} = ${item.result}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCalculationBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}
