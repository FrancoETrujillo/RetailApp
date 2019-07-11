package com.mvatech.ftrujillo.abfclone.features.shop.ui.adapters.categories

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mvatech.ftrujillo.abfclone.R
import com.mvatech.ftrujillo.abfclone.core.BaseViewHolder
import com.mvatech.ftrujillo.abfclone.core.GlideApp
import com.mvatech.ftrujillo.abfclone.core.inflate
import com.mvatech.ftrujillo.abfclone.features.shop.data.models.ClothingCategory
import com.mvatech.ftrujillo.abfclone.features.shop.data.models.categories_tab_wrappers.CategoriesCollectionsContent
import com.mvatech.ftrujillo.abfclone.features.shop.data.models.categories_tab_wrappers.CategoriesNewArrivalsContent
import kotlinx.android.synthetic.main.category_item.view.*
import kotlinx.android.synthetic.main.category_list_collections.view.*
import kotlinx.android.synthetic.main.category_list_new_arrivals.view.*
import timber.log.Timber

class CategoriesRecyclerAdapter(private var categoriesContent: List<Any> = listOf()) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    enum class CategoryType { NEW_ARRIVALS, CATEGORY, COLLECTIONS }

    private val pool = RecyclerView.RecycledViewPool()

    fun updateData(newContent: List<Any>){
        categoriesContent = newContent
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        Timber.d("franco %s", categoriesContent.size.toString())
        return when (viewType) {
            CategoryType.NEW_ARRIVALS.ordinal ->
                NewArrivalsHolder(parent.inflate(R.layout.category_list_new_arrivals))
            CategoryType.CATEGORY.ordinal ->
                CategoryHolder(parent.inflate(R.layout.category_item))
            CategoryType.COLLECTIONS.ordinal ->
                CollectionsHolder(parent.inflate(R.layout.category_list_collections))
            else -> throw IllegalArgumentException(viewType.toString())
        }
    }

    override fun getItemCount(): Int {
        return categoriesContent.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val item = categoriesContent[position]
        Timber.d("franco %s", categoriesContent[position].toString())
        when (holder) {
            is NewArrivalsHolder -> holder.bind(item as CategoriesNewArrivalsContent)
            is CategoryHolder -> holder.bind(item as ClothingCategory)
            is CollectionsHolder -> holder.bind(item as CategoriesCollectionsContent)
            else -> throw IllegalArgumentException()
        }

    }

    override fun getItemViewType(position: Int): Int {
        Timber.d("franco %s", categoriesContent[position].toString())
        return when (categoriesContent[position]) {
            is CategoriesNewArrivalsContent -> CategoryType.NEW_ARRIVALS.ordinal
            is ClothingCategory -> CategoryType.CATEGORY.ordinal
            is CategoriesCollectionsContent -> CategoryType.COLLECTIONS.ordinal
            else -> -1
        }
    }

    inner class NewArrivalsHolder(view: View) : BaseViewHolder<CategoriesNewArrivalsContent>(view) {
        override fun bind(item: CategoriesNewArrivalsContent) {
            itemView.categorieesNewArrivalsRecyclerView.apply {
                layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
                adapter = NewArrivalsRecyclerAdapter(item.newArrivals)
                setRecycledViewPool(pool)
            }
        }
    }

    inner class CategoryHolder(view: View) : BaseViewHolder<ClothingCategory>(view) {
        override fun bind(item: ClothingCategory) {
            itemView.categoryNameTextView.text = item.name
            GlideApp.with(itemView.context)
                .load(item.img)
                .into(this.itemView.categoryImageView)
        }

    }

    inner class CollectionsHolder(view: View) : BaseViewHolder<CategoriesCollectionsContent>(view) {
        override fun bind(item: CategoriesCollectionsContent) {
            itemView.categoriesCollectionRecyclerView.apply {
                layoutManager = GridLayoutManager(itemView.context, 2)
                adapter = CollectionsRecyclerAdapter(item.collections)
                setRecycledViewPool(pool)
            }
        }

    }


}