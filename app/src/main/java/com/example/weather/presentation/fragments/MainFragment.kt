package com.example.weather.presentation.fragments

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.weather.BASE_URL
import com.example.weather.MyApplication
import com.example.weather.presentation.MainViewModel
import com.example.weather.presentation.adapters.ViewPagerAdapter
import com.example.weather.data.ApiService
import com.example.weather.databinding.FragmentMainBinding
import com.example.weather.di.MyViewModelFactory
import com.example.weather.isPermissionGranted
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: MyViewModelFactory

    private val component by lazy {
        (requireActivity().application as MyApplication).component
    }

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    private val fList = listOf(
        HoursFragment.newInstance(),
        DaysFragment.newInstance()
    )

    private val tList = listOf(
        "Hours",
        "Days"
    )

    private lateinit var permissionLauncher: ActivityResultLauncher<String>

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding ?: throw RuntimeException("FragmentBinding=null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        component.inject(this)
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()
        init()
        viewModel.loadWeatherInfo()
        requestWeatherData()
    }

    private fun init() {
        val vpAdapter = ViewPagerAdapter(activity as FragmentActivity, fList)
        binding.viewPager.adapter = vpAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tList[position]
        }.attach()
    }

    private fun permissionListener() {
        permissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) {
                Toast.makeText(activity, "Permission is $it", Toast.LENGTH_LONG).show()
            }
    }

    private fun checkPermission() {
        if (!isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION)) {
            permissionListener()
            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    private fun requestWeatherData() {
        viewModel.weatherInfo.observe(viewLifecycleOwner){ response ->
            binding.tvCity.text = response.location.city
            binding.tvDate.text = response.location.time
            val minTemp = response.forecast.forecastday[0].day.minTemp.toString()
            val maxTemp = response.forecast.forecastday[0].day.maxTemp.toString()
            binding.tvMaxMinTemp.text = String.format("%s%s/%s%s",minTemp,"°",maxTemp,"°")
            binding.tvCurrentTemp.text=String.format("%s%s%s"," ",response.current.currentTemp.toString(),"°")
            binding.tvCondition.text=response.current.condition.conditionText
            activity?.let {
                Glide.with(it).load("https:"+response.current.condition.imageUrl)
                    .into(binding.imageWeather)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}