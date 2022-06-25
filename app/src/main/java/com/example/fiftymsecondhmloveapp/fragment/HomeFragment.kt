package com.example.fiftymsecondhmloveapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.fiftymsecondhmloveapp.App
import com.example.fiftymsecondhmloveapp.Prefs
import com.example.fiftymsecondhmloveapp.R
import com.example.fiftymsecondhmloveapp.databinding.FragmentHomeBinding
import com.example.fiftymsecondhmloveapp.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnCalculate.setOnClickListener {
                val firstName = etBoy.text.toString()
                val secondName = etGirl.text.toString()
                App.loveApi.getPercentage(firstName, secondName).enqueue(object :
                    Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        Log.e("ololo", "onResponse:${response.body()?.percentage}")
                        val love = response.body() as LoveModel
                        val bundle = Bundle()
                        bundle.putSerializable("love", love)
                        findNavController().navigate(R.id.resultFragment, bundle)
                        etBoy.text.clear()
                        etGirl.text.clear()
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("ololo", "onFailure:${t.message}")
                    }
                })
            }
        }
    }
}