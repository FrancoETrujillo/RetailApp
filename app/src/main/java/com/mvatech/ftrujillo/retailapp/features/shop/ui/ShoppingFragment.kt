package com.mvatech.ftrujillo.retailapp.features.shop.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mvatech.ftrujillo.retailapp.R
import com.mvatech.ftrujillo.retailapp.features.shop.ui.adapters.ShoppingPagerAdapter
import kotlinx.android.synthetic.main.shopping_fragment.*


class ShoppingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.shopping_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val fragmentList = listOf(
            Pair(getString(R.string.categories_tab_title), CategoriesFragment()),
            Pair(getString(R.string.explore_tab_title), ExploreFragment()),
            Pair(getString(R.string.new_arrivals_tab_title), NewArrivalsFragment())
        )
        bindTabLayout(fragmentList)
    }

    private fun bindTabLayout(fragmentList: List<Pair<String, Fragment>>) {
        fragmentManager ?. let {
            val pageAdapter = ShoppingPagerAdapter(it, fragmentList)
            shoppingViewPager.adapter = pageAdapter
            shoppingTabLayout.setupWithViewPager(shoppingViewPager)
            val tab = shoppingTabLayout.getTabAt(1)
            tab?.select()
        }
    }


}
