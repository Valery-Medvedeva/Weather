package com.example.weather.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather.BASE_URL
import com.example.weather.adapters.HoursRVAdapter
import com.example.weather.data.ApiService
import com.example.weather.databinding.FragmentHoursBinding
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HoursFragment : Fragment() {

    private val binding by lazy {
        FragmentHoursBinding.inflate(layoutInflater)
    }
    private val hoursRVAdapter by lazy {
        HoursRVAdapter()
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
            val hours=result.forecast.forecastday[0].hours
            binding.rvHours.layoutManager = LinearLayoutManager(activity)
            binding.rvHours.adapter = hoursRVAdapter
            hoursRVAdapter.submitList(hours)
        }
    }


    private fun initRv() {

    }

    companion object {
        @JvmStatic
        fun newInstance() = HoursFragment()
    }
}