package com.example.myrecyclerview

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun View.gone() {
    this.visibility = View.GONE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun ImageView.loadImageFromUrl(url: String?) {
    Glide.with(this).clear(this)
    Glide.with(this).load(url).apply(RequestOptions()).into(this)
}
