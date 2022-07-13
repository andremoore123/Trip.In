package com.andre.tripin.settings

import android.annotation.SuppressLint
import android.app.UiModeManager.MODE_NIGHT_NO
import android.app.UiModeManager.MODE_NIGHT_YES
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import com.andre.tripin.MainActivity
import com.andre.tripin.R
import com.google.android.material.switchmaterial.SwitchMaterial

class SettingsFragment : Fragment() {
    lateinit var sharedPreferences: SharedPreferences
    private var favoriteList = mutableSetOf("")

    @SuppressLint("WrongConstant")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_settings, container, false)
        val switch = view.findViewById<SwitchMaterial>(R.id.settings_switch_dark)
        val configuration = resources.configuration
        when (configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_NO -> {switch.isChecked = false} // Night mode is not active, we're using the light theme
            Configuration.UI_MODE_NIGHT_YES -> {switch.isChecked = true} // Night mode is active, we're using dark theme
        }

        sharedPreferences =
            (activity?.getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE) ?: when (sharedPreferences.getInt("night_mode", 2)) {
                0 -> AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
                1 -> AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
                else -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }) as SharedPreferences

        switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                sharedPreferences.edit().putInt("night_mode", 1).apply()
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
            } else{
                sharedPreferences.edit().putInt("night_mode", 0).apply()
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
            }
        }
        val sharedPref = activity?.getSharedPreferences("APPLICATION", Context.MODE_PRIVATE)
        favoriteList = sharedPref?.getStringSet("LIST_FAVORITE", favoriteList) as MutableSet<String>
        view.findViewById<Button>(R.id.settings_button_reset).setOnClickListener {
            favoriteList.clear()
            with (sharedPref.edit()) {
                putStringSet("LIST_FAVORITE", mutableSetOf<String>())
                apply()
            }
        }

        return view
    }
}