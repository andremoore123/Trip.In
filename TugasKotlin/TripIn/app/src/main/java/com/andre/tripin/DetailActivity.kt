package com.andre.tripin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.andre.tripin.adapter.DataItem
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailActivity : AppCompatActivity() {
    private var favoriteList = mutableSetOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val topAppBar = findViewById<MaterialToolbar>(R.id.detail_topAppBar)
        topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }
        val extras = intent.extras?.getParcelable<DataItem>("EXTRA")
        val detailImage = findViewById<ImageView>(R.id.detail_image)
        val detailTitle = findViewById<TextView>(R.id.detail_title)
        val detailDescription = findViewById<TextView>(R.id.detail_description)

        extras?.image?.let { detailImage.setBackgroundResource(it) }
        detailTitle.text = extras?.title
        detailDescription.text = extras?.description

        val sharedPref = this.getSharedPreferences("APPLICATION", Context.MODE_PRIVATE)
        favoriteList = sharedPref.getStringSet("LIST_FAVORITE", favoriteList) as MutableSet<String>

        findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener{
            if (!favoriteList.contains(extras?.title)){
                extras?.title?.let { it1 -> favoriteList.add(it1) }
                with (sharedPref.edit()) {
                    putStringSet("LIST_FAVORITE", favoriteList)
                    apply()
                }
                Log.d("List Favorite", favoriteList.toString())
            }
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}