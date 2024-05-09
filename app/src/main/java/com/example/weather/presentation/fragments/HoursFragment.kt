package com.example.weather.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather.BASE_URL
import com.example.weather.MyApplication
import com.example.weather.presentation.adapters.HoursRVAdapter
import com.example.weather.data.ApiService
import com.example.weather.databinding.FragmentHoursBinding
import com.example.weather.databinding.FragmentMainBinding
import com.example.weather.di.MyViewModelFactory
import com.example.weather.presentation.MainViewModel
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class HoursFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: MyViewModelFactory

    private val component by lazy {
        (requireActivity().application as MyApplication).component
    }

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }
    private var _binding: FragmentHoursBinding? = null
    private val binding: FragmentHoursBinding
        get() = _binding ?: throw RuntimeException("FragmentBinding=null")


    private val hoursRVAdapter by lazy {
        HoursRVAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        component.inject(this)
        _binding = FragmentHoursBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestWeatherData()
        binding.rvHours.layoutManager = LinearLayoutManager(activity)
        binding.rvHours.adapter=hoursRVAdapter
        observe()
    }


    private fun requestWeatherData() {
        viewModel.loadWeatherInfo()
    }

    private fun observe(){
        viewModel.weatherInfo.observe(viewLifecycleOwner){
            val list=it.forecast.forecastday[0].hours
            hoursRVAdapter.submitList(list)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        @JvmStatic
        fun newInstance() = HoursFragment()
    }
}