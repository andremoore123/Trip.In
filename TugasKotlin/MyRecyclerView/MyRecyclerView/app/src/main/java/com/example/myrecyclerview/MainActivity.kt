package com.example.myrecyclerview

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecyclerview.adapter.HeroAdapter
import com.example.myrecyclerview.data.models.HeroData
import com.example.myrecyclerview.databinding.ActivityMainBinding
import com.example.myrecyclerview.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: HeroAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE)
        when (sharedPreferences.getInt("night_mode", 2)) {
            0 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            1 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
//        binding.listHero.setHasFixedSize(true)

        showRecyclerView()
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MainViewModel::class.java)

        binding.btnSearch.setOnClickListener {
            hideKeyboard()
            val user = binding.edtSeachUser.text.toString()
            if (user.isEmpty()) return@setOnClickListener

            showLoading(true)

            viewModel.setUser(user)
        }

        viewModel.getUsers().observe(this) { items ->
            if (items != null) {
                adapter.setData(items)
                adapter.notifyDataSetChanged()
                showLoading(false)
            }
        }
        binding.topAppBar.setOnMenuItemClickListener{ menuItem ->
        when (menuItem.itemId){
            R.id.settings -> {
                val intent = Intent(this, SwitchMode::class.java)
                startActivity(intent)
                true
                }
            R.id.favorite ->{
                val intent = Intent(this, FavoriteActivity::class.java)
                startActivity(intent)
                true
            }
            else -> false
        }
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visible()
        } else {
            binding.progressBar.gone()
        }
    }

    private fun showRecyclerView() {
        adapter =   HeroAdapter()
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

    private fun hideKeyboard() {
        val hide = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        hide?.hideSoftInputFromWindow(binding.btnSearch.windowToken, 0)
    }
}

