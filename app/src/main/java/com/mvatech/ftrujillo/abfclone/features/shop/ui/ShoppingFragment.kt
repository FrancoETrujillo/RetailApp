package com.mvatech.ftrujillo.abfclone.features.shop.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.mvatech.ftrujillo.abfclone.R
import com.mvatech.ftrujillo.abfclone.databinding.ShoppingFragmentBinding
import com.mvatech.ftrujillo.abfclone.features.shop.ui.adapters.ShoppingPagerAdapter
import com.mvatech.ftrujillo.abfclone.features.shop.viewmodels.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_fragment.*


class ShoppingFragment : Fragment() {

    private lateinit var viewModel: ShoppingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.shopping_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ShoppingViewModel::class.java)

        val fragmentList = listOf(
            Pair(getString(R.string.categories_tab_title), CategoriesFragment()),
            Pair(getString(R.string.explore_tab_title), ExploreFragment()),
            Pair(getString(R.string.new_arrivals_tab_title), NewArrivalsFragment())
        )

        fragmentManager ?. let {
            val pageAdapter = ShoppingPagerAdapter(it, fragmentList)
            shoppingViewPager.adapter = pageAdapter
            shoppingTabLayout.setupWithViewPager(shoppingViewPager)
        }
    }

}
