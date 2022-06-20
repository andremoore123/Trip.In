package com.example.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModelProvider
import androidx.room.Insert
import com.example.myrecyclerview.adapter.SectionsPagerAdapter
import com.example.myrecyclerview.data.database.User
import com.example.myrecyclerview.data.database.UserDataViewModelFactory
import com.example.myrecyclerview.data.database.UserDatabase
import com.example.myrecyclerview.data.models.HeroData
import com.example.myrecyclerview.databinding.ActivityDetailBinding
import com.example.myrecyclerview.viewmodel.DetailViewModel
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayoutMediator

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var detailViewModel: DetailViewModel

    companion object {
        const val EXTRA_USERNAME = "extra_username"

        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.followers,
            R.string.following
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user = intent.getParcelableExtra<HeroData>(EXTRA_USERNAME) as HeroData

        val application = requireNotNull(this).application
        val dataSource = UserDatabase.getInstance(application).userDao
        val viewModelFactory = UserDataViewModelFactory(dataSource, application)
        detailViewModel = ViewModelProvider(
            this,
            viewModelFactory
        ).get(DetailViewModel::class.java)

//        binding.detailFavorite.setOnClickListener {
//            detailViewModel.insertDataToDatabase(it.toString())
//        }
        user.login?.let {
            detailViewModel.setDetailUser(it)
        }
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val sectionPagerAdapter = SectionsPagerAdapter(this)
        sectionPagerAdapter.username = user.login.toString()

        val viewPager = binding.viewPager
        viewPager.adapter = sectionPagerAdapter

        val tabs = binding.tabs

        detailViewModel.getDetailUser().observe(this) {
            with(binding) {
                imgItemPhoto.loadImageFromUrl(it.avatar)

                if (it.name.isNullOrEmpty()||it.name.equals("null")){
                    tvItemName.gone()
                }
                if (it.location.isNullOrEmpty()||it.location.equals("null")){
                    location.gone()
                }
                if (it.company.isNullOrEmpty()||it.company.equals("null")){
                    com.gone()
                }

                toolbar.title = it.login
                tvItemName.text = it.name
                location.text = it.location
                com.text = it.company
                loginUsername.text = it.login

                var isShow = true
                var scrollRange = -1
                binding.appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { barLayout, verticalOffset ->
                    if (scrollRange == -1){
                        scrollRange = barLayout?.totalScrollRange!!
                    }
                    if (scrollRange + verticalOffset == 0){
                        collapsingToolbar.title = it.login
                        isShow = true
                    } else if (isShow){
                        collapsingToolbar.title = " "
                        //careful there should a space between double quote otherwise it wont work
                        isShow = false
                    }
                })

                TabLayoutMediator(tabs, viewPager) { tab, pos ->
                    if (pos==0){
                        tab.text = "${resources.getString(TAB_TITLES[pos])} ${it.followers}"
                    }else{
                        tab.text = "${resources.getString(TAB_TITLES[pos])} ${it.following}"
                    }

                }.attach()
            }
        }
    }

}