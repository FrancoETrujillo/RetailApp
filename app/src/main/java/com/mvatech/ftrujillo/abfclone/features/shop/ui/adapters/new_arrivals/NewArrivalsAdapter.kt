package com.mvatech.ftrujillo.abfclone.features.shop.ui.adapters.new_arrivals

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mvatech.ftrujillo.abfclone.R
import com.mvatech.ftrujillo.abfclone.core.GlideApp
import com.mvatech.ftrujillo.abfclone.core.inflate
import com.mvatech.ftrujillo.abfclone.features.shop.data.models.NewArrival
import com.mvatech.ftrujillo.abfclone.features.shop.ui.adapters.explore.DiffUtilImpl
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
            itemView.title.text = newArrival.name
            itemView.price.text = newArrival.price.toFloat().toString()

            itemView.collectionInfo.text = newArrival.collection
            itemView.trendType.text = newArrival.trendType
            GlideApp.with(itemView.context)
                .load(newArrival.image)
                .into(itemView.image)
        }
    }
}