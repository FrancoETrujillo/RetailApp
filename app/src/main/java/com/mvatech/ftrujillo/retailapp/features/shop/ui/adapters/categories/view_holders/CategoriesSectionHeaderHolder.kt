package com.mvatech.ftrujillo.retailapp.features.shop.ui.adapters.categories.view_holders

import android.view.View
import com.mvatech.ftrujillo.retailapp.core.BaseViewHolder
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.categories_tab_wrappers.CategoriesSectionHeader
import kotlinx.android.synthetic.main.section_header.view.*

class CategoriesSectionHeaderHolder(view: View) : BaseViewHolder<CategoriesSectionHeader>(view) {
    override fun bind(item: CategoriesSectionHeader) {
        itemView.sectionTitle.text = item.headerName
    }
}