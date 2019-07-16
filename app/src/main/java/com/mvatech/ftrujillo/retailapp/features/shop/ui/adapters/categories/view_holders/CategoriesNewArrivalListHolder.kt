package com.mvatech.ftrujillo.retailapp.features.shop.ui.adapters.categories.view_holders

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mvatech.ftrujillo.retailapp.core.BaseViewHolder
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.categories_tab_wrappers.CategoriesNewArrivalsContent
import com.mvatech.ftrujillo.retailapp.features.shop.ui.adapters.categories.CategoriesNewArrivalsRecyclerAdapter
import kotlinx.android.synthetic.main.category_list_new_arrivals.view.*

class CategoriesNewArrivalListHolder(view: View, private val pool: RecyclerView.RecycledViewPool) : BaseViewHolder<CategoriesNewArrivalsContent>(view) {
    override fun bind(item: CategoriesNewArrivalsContent) {
        val newArrivalsAdapter = CategoriesNewArrivalsRecyclerAdapter(item.newArrivals)
        itemView.categoriesNewArrivalsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
            adapter = newArrivalsAdapter
            setRecycledViewPool(pool)
        }
        itemView.categoriesNewArrivalsRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                newArrivalsAdapter.scrollDirection =
                    if (dx < 0)
                        CategoriesNewArrivalsRecyclerAdapter.ScrollDirection.LEFT
                    else
                        CategoriesNewArrivalsRecyclerAdapter.ScrollDirection.RIGHT
            }
        })
    }
}