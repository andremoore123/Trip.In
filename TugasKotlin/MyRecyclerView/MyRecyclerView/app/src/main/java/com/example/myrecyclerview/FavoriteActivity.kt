package com.example.myrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecyclerview.adapter.HeroAdapter
import com.example.myrecyclerview.data.database.FavoriteViewModelFactory
import com.example.myrecyclerview.data.database.UserDatabase
import com.example.myrecyclerview.data.models.HeroData
import com.example.myrecyclerview.databinding.ActivityFavoriteBinding
import com.example.myrecyclerview.viewmodel.FavoriteViewModel

class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var adapter: HeroAdapter
    private lateinit var viewModel: FavoriteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val application = requireNotNull(this).application
        val dataSource = UserDatabase.getInstance(application).userDao
        val viewModelFactory = FavoriteViewModelFactory(dataSource, application)
        viewModel = ViewModelProvider(
            this,
            viewModelFactory
        ).get(FavoriteViewModel::class.java)
        showRecyclerView()
        viewModel.setFavoriteUser()
        viewModel.getUsers().observe(this) { items ->
            if (items != null) {
                Log.d("Keberhasilan", "Tidak Null")
                adapter.setData(items)
                adapter.notifyDataSetChanged()
            }
        }
        binding.buttonDelete.setOnClickListener{viewModel.deleteUser()}
    }


    private fun showRecyclerView() {
        Log.d("Jalan", "Succses")
        adapter = HeroAdapter()
        adapter.notifyDataSetChanged()
        binding.listHero.layoutManager = LinearLayoutManager(this)
        binding.listHero.adapter = adapter
        adapter.setOnItemClickCallback(object : HeroAdapter.OnItemClickCallback {
            override fun onItemClicked(data: HeroData) {
                showSelectedUser(data)
            }
        })
    }
    private fun showSelectedUser(user: HeroData) {
        val move = Intent(this, DetailActivity::class.java)
        move.putExtra(DetailActivity.EXTRA_USERNAME, user)
        startActivity(move)
    }
}