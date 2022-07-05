package com.andre.tripin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.andre.tripin.adapter.DataItem
import com.google.android.material.appbar.MaterialToolbar

class DetailActivity : AppCompatActivity() {
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

        extras?.image?.let { detailImage.setImageResource(it) }
        detailTitle.text = extras?.title
        detailDescription.text = extras?.description
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}