package com.mvatech.ftrujillo.retailapp.features.shop.ui.adapters.categories

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvatech.ftrujillo.retailapp.R
import com.mvatech.ftrujillo.retailapp.core.BaseViewHolder
import com.mvatech.ftrujillo.retailapp.core.inflate
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.ClothingCategory
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.ClothingCollection
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.categories_tab_wrappers.CategoriesNewArrivalsContent
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.categories_tab_wrappers.CategoriesSectionHeader
import com.mvatech.ftrujillo.retailapp.features.shop.ui.adapters.categories.view_holders.CategoriesCollectionHolder
import com.mvatech.ftrujillo.retailapp.features.shop.ui.adapters.categories.view_holders.CategoriesNewArrivalListHolder
import com.mvatech.ftrujillo.retailapp.features.shop.ui.adapters.categories.view_holders.CategoryItemHolder
import com.mvatech.ftrujillo.retailapp.features.shop.ui.adapters.categories.view_holders.CategoriesSectionHeaderHolder
import timber.log.Timber

class CategoriesRecyclerAdapter(private var categoriesContent: List<Any> = listOf()) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    enum class CategoryType { NEW_ARRIVALS, CATEGORY, COLLECTIONS, SECTION_HEADER }

    private val pool = RecyclerView.RecycledViewPool()

    fun updateData(newContent: List<Any>) {
        categoriesContent = newContent
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            CategoryType.NEW_ARRIVALS.ordinal ->
                CategoriesNewArrivalListHolder(parent.inflate(R.layout.category_list_new_arrivals), pool)
            CategoryType.CATEGORY.ordinal ->
                CategoryItemHolder(parent.inflate(R.layout.category_item))
            CategoryType.COLLECTIONS.ordinal ->
                CategoriesCollectionHolder(parent.inflate(R.layout.category_list_collection_item))
            CategoryType.SECTION_HEADER.ordinal -> CategoriesSectionHeaderHolder(parent.inflate(R.layout.section_header))
            else -> throw IllegalArgumentException(viewType.toString())
        }
    }

    override fun getItemCount(): Int {
        return categoriesContent.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val item = categoriesContent[position]
        Timber.d("Franco holder is type %s,--- %s", holder is CategoriesCollectionHolder, holder.javaClass.name)
        Timber.d("Franco trying to bind position %d content = %s", position, item.toString())
        when (holder) {
            is CategoriesNewArrivalListHolder -> holder.bind(item as CategoriesNewArrivalsContent)
            is CategoryItemHolder -> holder.bind(item as ClothingCategory)
            is CategoriesCollectionHolder -> holder.bind(item as ClothingCollection)
            is CategoriesSectionHeaderHolder -> holder.bind(item as CategoriesSectionHeader)
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (categoriesContent[position]) {
            is CategoriesNewArrivalsContent -> CategoryType.NEW_ARRIVALS.ordinal
            is ClothingCategory -> CategoryType.CATEGORY.ordinal
            is ClothingCollection -> CategoryType.COLLECTIONS.ordinal
            is CategoriesSectionHeader -> CategoryType.SECTION_HEADER.ordinal
            else -> -1
        }
    }

    fun getSpanSizeAtPosition(position: Int): Int {
        return when (categoriesContent[position]) {
            is ClothingCollection -> 1
            else -> 2
        }

    }
}