package com.example.fiftymsecondhmloveapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultRegistry
import androidx.navigation.fragment.findNavController
import com.example.fiftymsecondhmloveapp.databinding.FragmentResultBinding
import com.example.fiftymsecondhmloveapp.model.LoveModel
import java.io.Serializable


class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        result()

    }

    private fun result() {
        val love = arguments?.getSerializable("love") as LoveModel
        with(binding) {
            etBoy.text = love.firstName
            etGirl.text = love.secondName
            tvResult.text = love.result
            tvPercentage.text = love.percentage.plus("%")
            btnTryAgain.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }
}