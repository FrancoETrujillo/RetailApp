package com.mvatech.ftrujillo.retailapp.features.shop.ui.adapters.categories.view_holders

import android.graphics.Paint
import android.view.View
import com.mvatech.ftrujillo.retailapp.core.BaseViewHolder
import com.mvatech.ftrujillo.retailapp.core.GlideApp
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.ClothingCollection
import kotlinx.android.synthetic.main.category_list_collection_item.view.*

class CategoriesCollectionHolder(view: View) : BaseViewHolder<ClothingCollection>(view) {
    override fun bind(item: ClothingCollection) {

        itemView.collectionName.apply {
            paintFlags = this.paintFlags or Paint.UNDERLINE_TEXT_FLAG
            text = item.name
        }

        GlideApp.with(itemView.context)
            .load(item.img)
            .into(this.itemView.collectionItemImageView)
    }
}