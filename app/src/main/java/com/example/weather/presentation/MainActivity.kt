package com.example.weather.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weather.R
import com.example.weather.presentation.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.placeHolder, MainFragment.newInstance())
            .addToBackStack(null)
            .commit()

    }
}