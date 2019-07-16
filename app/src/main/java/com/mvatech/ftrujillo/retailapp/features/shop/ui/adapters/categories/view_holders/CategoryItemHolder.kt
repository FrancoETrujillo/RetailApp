package com.mvatech.ftrujillo.retailapp.features.shop.ui.adapters.categories.view_holders

import android.graphics.Color
import android.view.View
import com.mvatech.ftrujillo.retailapp.core.BaseViewHolder
import com.mvatech.ftrujillo.retailapp.core.GlideApp
import com.mvatech.ftrujillo.retailapp.core.animateViewSlideFromRight
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.ClothingCategory
import kotlinx.android.synthetic.main.category_item.view.*

class CategoryItemHolder(view: View) : BaseViewHolder<ClothingCategory>(view) {
    override fun bind(item: ClothingCategory) {
        itemView.categoryNameTextView.text = item.name
        if (item.highlighted) {
            itemView.categoryNameTextView.apply {
                setTextColor(Color.RED)
            }
        }
        GlideApp.with(itemView.context)
            .load(item.img)
            .into(this.itemView.categoryImageView)
        animateViewSlideFromRight(itemView)
    }

}