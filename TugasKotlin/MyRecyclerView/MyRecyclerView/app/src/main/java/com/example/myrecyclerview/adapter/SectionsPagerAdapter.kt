package com.example.myrecyclerview.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myrecyclerview.FollowerFragment
import com.example.myrecyclerview.FollowingFragment

class SectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    var username : String? = null

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment : Fragment? = null
        when(position) {
            0 -> fragment = FollowerFragment.newInstance(username!!)
            1 -> fragment = FollowingFragment.newInstance(username!!)
        }
        return fragment as Fragment
    }

}