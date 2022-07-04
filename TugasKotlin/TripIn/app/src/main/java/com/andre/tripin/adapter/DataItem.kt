package com.andre.tripin.adapter

import androidx.annotation.DrawableRes

data class DataItem (
    @DrawableRes var image: Int,
    var title: String,
    val subtitle: String,
    val description: String)