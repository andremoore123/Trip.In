package com.andre.tripin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.andre.tripin.adapter.DataItem
import com.andre.tripin.adapter.RecyclerViewAdapter
import com.andre.tripin.profile.ProfileActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.collections.mutableListOf as mutableListOf1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val topAppBar = findViewById<MaterialToolbar>(R.id.topAppBar)
        topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navHostMainController = navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.exploreFragment -> {
                    navHostMainController.navigate(R.id.exploreFragment)
                    topAppBar.title = "Explore"
                    true
                }
                R.id.favoriteFragment -> {
                    navHostMainController.navigate(R.id.favoriteFragment)
                    topAppBar.title = "Favorite"
                    true
                }
                R.id.profileFragment -> {
                    navHostMainController.navigate(R.id.profileFragment)
                    topAppBar.title = "Settings"
                    true
                }
                else -> false
            }
        }

    }

}

