package com.mvatech.ftrujillo.abfclone.features.shop.ui.adapters.categories

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvatech.ftrujillo.abfclone.R
import com.mvatech.ftrujillo.abfclone.core.GlideApp
import com.mvatech.ftrujillo.abfclone.core.inflate
import com.mvatech.ftrujillo.abfclone.features.shop.data.models.NewArrival
import kotlinx.android.synthetic.main.category_new_arrivals_item.view.*

class NewArrivalsRecyclerAdapter(private val newArrivalList: List<NewArrival>) :
    RecyclerView.Adapter<NewArrivalsRecyclerAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(parent.inflate(R.layout.category_new_arrivals_item, false))
    }

    override fun getItemCount(): Int = newArrivalList.size


    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(newArrivalList[position])
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val context:Context
        init {
            itemView.setOnClickListener(this)
            context = itemView.context
        }

        override fun onClick(v: View?) {

        }

        fun bind(newArrival: NewArrival) {
            GlideApp.with(context)
                .load(newArrival.image)
                .into(this.itemView.categoryNewArrivalImageView)
        }

    }
}
