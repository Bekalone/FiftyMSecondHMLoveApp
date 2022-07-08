package com.example.fiftymsecondhmloveapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fiftymsecondhmloveapp.databinding.ItemHistoryBinding
import com.example.fiftymsecondhmloveapp.model.LoveModel

class HistoryAdapter(private var list: List<LoveModel>) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(ItemHistoryBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class HistoryViewHolder(private val binding:ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(loveModel: LoveModel) {
            binding.firstName.text = loveModel.firstName
            binding.secondName.text = loveModel.secondName
        }

    }
}