package com.andre.tripin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.appbar.MaterialToolbar

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        var topAppBar = findViewById<MaterialToolbar>(R.id.profile_topAppBar)
        topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }

    }
}