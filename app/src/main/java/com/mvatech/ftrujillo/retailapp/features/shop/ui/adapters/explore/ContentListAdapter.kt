package com.mvatech.ftrujillo.retailapp.features.shop.ui.adapters.explore

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.mvatech.ftrujillo.retailapp.R
import com.mvatech.ftrujillo.retailapp.core.inflate
import com.mvatech.ftrujillo.retailapp.core.toast
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.Content
import kotlinx.android.synthetic.main.content_list_item.view.*


class ContentListAdapter(mContext: Context, contentList: List<Content>) :
    ArrayAdapter<Content>(mContext, 0, contentList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, parent)
    }

    private fun initView(position: Int, parent: ViewGroup): View {
        val view = parent.inflate(R.layout.content_list_item)
        getItem(position)?.let {
            view.contentText.text = it.title
        }
        return view
    }

}
