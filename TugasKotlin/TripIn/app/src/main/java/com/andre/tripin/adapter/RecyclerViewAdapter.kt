package com.andre.tripin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.andre.tripin.R
import java.util.*
import android.widget.TextView as TextView1

class RecyclerViewAdapter(private val dataSet: MutableList<DataItem>, private val layout: Int): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.card_image)
        val title: TextView1 = view.findViewById(R.id.card_title)
        val subtitle: TextView1 = view.findViewById(R.id.card_subtitle)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(layout, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item =  dataSet[position]
        viewHolder.image.setImageResource(item.image)
        viewHolder.title.text = item.title
        viewHolder.subtitle.text = item.subtitle
    }
    override fun getItemCount() = dataSet.size
}