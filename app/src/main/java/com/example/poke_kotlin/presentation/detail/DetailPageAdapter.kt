package com.example.poke_kotlin.presentation.detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class DetailPageAdapter(fm: FragmentManager, fragments: ArrayList<FragmentPage>) : FragmentStatePagerAdapter(fm) {

    private var fragments = fragments

    override fun getCount(): Int  = fragments.size

    override fun getItem(position: Int): Fragment {
        return fragments[position].fragment
    }

    override fun getPageTitle(position: Int): CharSequence {
        return fragments[position].title
    }
}
