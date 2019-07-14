package com.mvatech.ftrujillo.retailapp.features.shop.ui.adapters.categories

import android.graphics.Paint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvatech.ftrujillo.retailapp.R
import com.mvatech.ftrujillo.retailapp.core.GlideApp
import com.mvatech.ftrujillo.retailapp.core.inflate
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.ClothingCollection
import kotlinx.android.synthetic.main.category_list_collection_item.view.*

class CategoriesCollectionsRecyclerAdapter(private val collections: List<ClothingCollection>) :
    RecyclerView.Adapter<CategoriesCollectionsRecyclerAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(parent.inflate(R.layout.category_list_collection_item))
    }

    override fun getItemCount() = collections.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(collections[position])
    }

    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(collection: ClothingCollection) {
            itemView.collectionName.apply {
                paintFlags = this.paintFlags or Paint.UNDERLINE_TEXT_FLAG
                text = collection.name
            }

            GlideApp.with(itemView.context)
                .load(collection.img)
                .into(this.itemView.collectionItemImageView)
        }
    }
}