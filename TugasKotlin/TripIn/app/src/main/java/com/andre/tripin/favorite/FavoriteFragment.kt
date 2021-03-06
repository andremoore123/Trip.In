package com.andre.tripin.favorite

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andre.tripin.DetailActivity
import com.andre.tripin.R
import com.andre.tripin.adapter.DataItem
import com.andre.tripin.adapter.RecyclerViewAdapter
import com.andre.tripin.explore.ExploreFragment

class FavoriteFragment : Fragment(), RecyclerViewAdapter.OnItemClickListener {
    private val list: MutableList<DataItem> = ExploreFragment().createList()
    private var favoriteShowList = mutableListOf<DataItem>()
    private val indoList: MutableList<DataItem> = ExploreFragment().createIndoList()
    private var favoriteList = mutableSetOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorite, container, false)
        val sharedPref = activity?.getSharedPreferences("APPLICATION", Context.MODE_PRIVATE)
        favoriteList = sharedPref?.getStringSet("LIST_FAVORITE", mutableSetOf<String>()) as MutableSet<String>
        Log.d("Favor List", favoriteList.toString())
        favoriteShowList = mutableListOf()
        if (favoriteList.isNotEmpty() && (list.isNotEmpty() || indoList.isNotEmpty())){
            for (i in list){
                if (favoriteList.contains(i.title)){
                    favoriteShowList.add(i)
                }
            }
            for (j in indoList){
                if (favoriteList.contains(j.title)){
                    favoriteShowList.add(j)
                }
            }
        }
        val recyclerViewFavorite = view.findViewById<RecyclerView>(R.id.favorite_fragment_recycler)
        recyclerViewFavorite.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerViewAdapter(favoriteShowList, R.layout.horizontal_card, this@FavoriteFragment)
        }
        val swipeHandler = object : SwipeToDeleteCallback(context) {

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter = recyclerViewFavorite.adapter as RecyclerViewAdapter
                favoriteList.remove((adapter.getItem(viewHolder.adapterPosition)).title)
                Log.d("Favor remove", favoriteList.toString())
                with (sharedPref.edit()) {
                    putStringSet("LIST_FAVORITE", favoriteList)
                    apply()
                }
                adapter.removeAt(viewHolder.adapterPosition)

            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(recyclerViewFavorite)
        recyclerViewFavorite.setHasFixedSize(true)
        return view
    }

    override fun onItemClick(data: DataItem) {
        Intent(activity, DetailActivity::class.java).apply {
            putExtra("EXTRA", data)
            startActivity(this)
        }
    }
}
