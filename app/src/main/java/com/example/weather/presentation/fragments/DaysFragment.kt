package com.example.weather.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather.MyApplication
import com.example.weather.databinding.FragmentDaysBinding
import com.example.weather.databinding.FragmentMainBinding
import com.example.weather.di.MyViewModelFactory
import com.example.weather.presentation.MainViewModel
import com.example.weather.presentation.adapters.DaysRVAdapter
import javax.inject.Inject

class DaysFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: MyViewModelFactory

    private val component by lazy {
        (requireActivity().application as MyApplication).component
    }

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    private var _binding: FragmentDaysBinding? = null
    private val binding: FragmentDaysBinding
        get() = _binding ?: throw RuntimeException("FragmentBinding=null")

    private val daysRVAdapter by lazy {
        DaysRVAdapter()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        component.inject(this)
        _binding = FragmentDaysBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestWeatherData()
        binding.rvDays.layoutManager = LinearLayoutManager(activity)
        binding.rvDays.adapter=daysRVAdapter
        observe()
    }

    private fun requestWeatherData() {
        viewModel.loadWeatherInfo()
    }

    private fun observe(){
        viewModel.weatherInfo.observe(viewLifecycleOwner){
            val list=it.forecast.forecastday
            daysRVAdapter.submitList(list)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        @JvmStatic
        fun newInstance() = DaysFragment()
    }
}