package com.example.myrecyclerview

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import com.example.myrecyclerview.databinding.ActivitySwitchModeBinding
import com.example.myrecyclerview.viewmodel.SwitchModeViewModel

class SwitchMode : AppCompatActivity() {
    private lateinit var binding: ActivitySwitchModeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lateinit var sharedPreferences: SharedPreferences

        binding = ActivitySwitchModeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val configuration = resources.configuration
        val currentNightMode = configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        when (currentNightMode) {
            Configuration.UI_MODE_NIGHT_NO -> {binding.switchMode.isChecked = false} // Night mode is not active, we're using the light theme
            Configuration.UI_MODE_NIGHT_YES -> {binding.switchMode.isChecked = true} // Night mode is active, we're using dark theme
        }
        sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE)
        when (sharedPreferences.getInt("night_mode", 2)) {
            0 -> AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
            1 -> AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
            else -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }

        binding.switchMode.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                sharedPreferences.edit().putInt("night_mode", 1).apply()
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
            } else{
                sharedPreferences.edit().putInt("night_mode", 0).apply()
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
            }
        }
    }

}