package com.example.fiftymsecondhmloveapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.fiftymsecondhmloveapp.App
import com.example.fiftymsecondhmloveapp.HistoryAdapter
import com.example.fiftymsecondhmloveapp.R
import com.example.fiftymsecondhmloveapp.databinding.FragmentHistoryBinding
import com.example.fiftymsecondhmloveapp.room.AppDataBase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    lateinit var adapter: HistoryAdapter
    lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHistoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeHistory()
    }

    private fun observeHistory() {
        App.db.historyDao().getAll().observe(viewLifecycleOwner) { data ->
            adapter = HistoryAdapter(data)
            binding.recyclerView.adapter = adapter
        }
    }
}