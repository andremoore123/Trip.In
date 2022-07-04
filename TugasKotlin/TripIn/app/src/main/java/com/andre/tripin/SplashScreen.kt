package com.andre.tripin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import java.lang.Boolean.getBoolean

@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {
    private val status: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE)
        val defaultStatus = sharedPref.getBoolean(getString(R.string.status), status)
        if (!defaultStatus){
            with (sharedPref.edit()) {
                putBoolean(getString(R.string.status), true)
                apply()
            }
            Handler().postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                onDestroy()
            }, 3000)
        } else if (defaultStatus){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}