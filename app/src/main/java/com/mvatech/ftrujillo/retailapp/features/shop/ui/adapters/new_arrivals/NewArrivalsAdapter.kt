package com.mvatech.ftrujillo.retailapp.features.shop.ui.adapters.new_arrivals

import android.graphics.Paint
import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.mvatech.ftrujillo.retailapp.R
import com.mvatech.ftrujillo.retailapp.core.GlideApp
import com.mvatech.ftrujillo.retailapp.core.inflate
import com.mvatech.ftrujillo.retailapp.core.toCurrencyString
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.NewArrival
import kotlinx.android.synthetic.main.new_arrivals_list_item.view.*

class NewArrivalsAdapter(private var newArrivalList: List<NewArrival> = listOf()): RecyclerView.Adapter<NewArrivalsAdapter.Holder>(){
    fun updateData(newData: List<NewArrival>){
        newArrivalList = newData
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(parent.inflate(R.layout.new_arrivals_list_item))
    }

    override fun getItemCount() = newArrivalList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(newArrivalList[position])
    }

    inner class Holder(view: View): RecyclerView.ViewHolder(view){

        fun bind(newArrival: NewArrival){
            itemView.apply {
                title.text = newArrival.name
                price.text = newArrival.price.toCurrencyString()
                newArrival.discountedPrice?.let {
                    price.setTextColor(ResourcesCompat.getColor(resources, R.color.colorContrastGray, null))
                    price.setTypeface(price.typeface,Typeface.NORMAL)
                    price.paintFlags = price.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

                    discountedPrice.text = it.toCurrencyString()
                    discountedPrice.visibility = View.VISIBLE
                } ?:run {
                    discountedPrice.visibility = View.GONE
                }
                collectionInfo.text = newArrival.collection
                trendType.text = newArrival.trendType
            }
            GlideApp.with(itemView.context)
                .load(newArrival.image)
                .into(itemView.image)
        }
    }
}