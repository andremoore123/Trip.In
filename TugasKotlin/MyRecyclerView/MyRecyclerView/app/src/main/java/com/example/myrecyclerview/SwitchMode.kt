package com.example.myrecyclerview

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

        binding = ActivitySwitchModeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val configuration = resources.configuration
        val currentNightMode = configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        when (currentNightMode) {
            Configuration.UI_MODE_NIGHT_NO -> {binding.switchMode.isChecked = false} // Night mode is not active, we're using the light theme
            Configuration.UI_MODE_NIGHT_YES -> {binding.switchMode.isChecked = true} // Night mode is active, we're using dark theme
        }

        binding.switchMode.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
            } else{
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
            }
        }
    }

    override fun onBackPressed() {
        this.finish()
    }
}