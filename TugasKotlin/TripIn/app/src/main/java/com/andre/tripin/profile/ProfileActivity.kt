package com.andre.tripin.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andre.tripin.R
import com.google.android.material.appbar.MaterialToolbar

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val topAppBar = findViewById<MaterialToolbar>(R.id.profile_topAppBar)
        topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}