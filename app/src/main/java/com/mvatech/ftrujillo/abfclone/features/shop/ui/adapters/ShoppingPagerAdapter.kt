package com.mvatech.ftrujillo.abfclone.features.shop.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ShoppingPagerAdapter(
    fragmentManager: FragmentManager,
    private val fragments: List<Pair<String, Fragment>> = listOf()
) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return fragments[position].second
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragments[position].first
    }

}