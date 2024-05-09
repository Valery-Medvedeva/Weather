package com.example.weather.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather.BASE_URL
import com.example.weather.R
import com.example.weather.presentation.adapters.DaysRVAdapter
import com.example.weather.presentation.adapters.HoursRVAdapter
import com.example.weather.data.ApiService
import com.example.weather.databinding.FragmentDaysBinding
import com.example.weather.databinding.FragmentHoursBinding
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DaysFragment : Fragment() {

    private val binding by lazy {
        FragmentDaysBinding.inflate(layoutInflater)
    }
    private val daysRVAdapter by lazy {
        DaysRVAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestWeatherData()
    }


    private fun requestWeatherData() {
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        lifecycleScope.launch {
            val result = api.getResponse()
            val days=result.forecast.forecastday
            binding.rvDays.layoutManager = LinearLayoutManager(activity)
            binding.rvDays.adapter = daysRVAdapter
            daysRVAdapter.submitList(days)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = DaysFragment()
    }
}