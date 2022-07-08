package com.andre.tripin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.andre.tripin.R
import android.widget.TextView as TextView1

class RecyclerViewAdapter(
    private val dataSet: MutableList<DataItem>,
    private val layout: Int,
    private val listener: OnItemClickListener
): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val image: ImageView = view.findViewById(R.id.card_image)
        val title: TextView1 = view.findViewById(R.id.card_title)
        val subtitle: TextView1 = view.findViewById(R.id.card_subtitle)
        init{
            view.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            val data: DataItem = dataSet[position]
            if (position != RecyclerView.NO_POSITION){
                listener.onItemClick(data)
            }
        }
    }
    interface OnItemClickListener{
        fun onItemClick(data: DataItem)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(layout, viewGroup, false)
        view.setOnClickListener{
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item =  dataSet[position]
        viewHolder.image.setBackgroundResource(item.image)
        viewHolder.title.text = item.title
        viewHolder.subtitle.text = item.subtitle

    }
    override fun getItemCount() = dataSet.size

    fun removeAt(position: Int) {
        dataSet.removeAt(position)
        notifyItemRemoved(position)
    }
    fun getItem(position: Int): DataItem {
        return (dataSet[position])
    }
}
