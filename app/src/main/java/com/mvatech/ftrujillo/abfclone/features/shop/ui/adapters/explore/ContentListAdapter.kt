package com.mvatech.ftrujillo.abfclone.features.shop.ui.adapters.explore

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.mvatech.ftrujillo.abfclone.R
import com.mvatech.ftrujillo.abfclone.core.inflate
import com.mvatech.ftrujillo.abfclone.core.toast
import com.mvatech.ftrujillo.abfclone.features.shop.data.models.Content
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
            view.setOnClickListener { _ -> callWebViewActivity(it.target) }
        }
        return view
    }

    private fun callWebViewActivity(target: String) {
//        val intent = Intent(mContext, WebViewActivity::class.java)
//        intent.putExtra(URL_BUNDLE_ID, target)
//        mContext.startActivity(intent)
        "Something clicked".toast(this.context)
    }

}
