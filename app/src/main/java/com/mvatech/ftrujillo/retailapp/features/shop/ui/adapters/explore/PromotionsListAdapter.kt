package com.mvatech.ftrujillo.retailapp.features.shop.ui.adapters.explore

import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mvatech.ftrujillo.retailapp.R
import com.mvatech.ftrujillo.retailapp.core.inflate
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.Promotion
import kotlinx.android.synthetic.main.promotions_recyclerview_item.view.*
import timber.log.Timber
import java.util.*

class PromotionsListAdapter : RecyclerView.Adapter<PromotionsListAdapter.Holder>() {
    private val mItemList: MutableList<Promotion>

    init {
        mItemList = ArrayList()
    }

    fun updateData(itemList: List<Promotion>) {
        val result = DiffUtil.calculateDiff(
                DiffUtilImpl(
                        mItemList,
                        itemList
                )
        )
        mItemList.clear()
        mItemList.addAll(itemList)
        result.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(parent.inflate(R.layout.promotions_recyclerview_item))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(mItemList[position])

    }

    override fun getItemCount(): Int {
        return mItemList.size
    }

    inner class Holder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(promotion: Promotion) {
            view.apply {
                if(promotion.title.isNotEmpty()){
                    title.visibility = View.VISIBLE
                    title.text = promotion.title
                } else{
                    title.visibility = View.GONE
                }
                if(!promotion.promoMessage.isNullOrEmpty()){
                    promoMessage.visibility = View.VISIBLE
                    promoMessage.text = promotion.promoMessage
                } else {
                    promoMessage.visibility = View.GONE
                }


                promotion.topDescription?.let {
                    if(it.isNotEmpty()) {
                        topDescription.visibility = View.VISIBLE
                        topDescription.text = promotion.topDescription
                    } else {
                        topDescription.visibility = View.GONE
                    }
                }

                promotion.bottomDescription?.let {
                    if(it.isNotEmpty()){
                        bottomDescription.visibility = View.VISIBLE
                        bottomDescription.text =
                            HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_LEGACY)
                    } else{
                        bottomDescription.visibility = View.GONE
                    }

                }

                if(!promotion.content.isNullOrEmpty()){
                    content.visibility = View.VISIBLE
                    contentListView.visibility = View.VISIBLE
                    val adapter = ContentListAdapter(context, promotion.content)
                    contentListView.adapter = adapter
                    Timber.d("Content: %s", promotion.content)
                } else {
                    content.visibility = View.GONE
                    contentListView.visibility = View.GONE
                }

                context.let { Glide.with(it).load(promotion.backgroundImage).into(promotionImage) }
            }

        }
    }
}
