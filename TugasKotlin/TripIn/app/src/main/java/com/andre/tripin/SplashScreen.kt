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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
            Handler().postDelayed({
                Intent(this, MainActivity::class.java).also{
                    startActivity(it)
                    finish()
                }

            }, 3000)

    }
}