package com.mvatech.ftrujillo.retailapp.features.shop.ui.adapters.categories

import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.mvatech.ftrujillo.retailapp.R
import com.mvatech.ftrujillo.retailapp.core.GlideApp
import com.mvatech.ftrujillo.retailapp.core.inflate
import com.mvatech.ftrujillo.retailapp.features.shop.data.models.NewArrival
import kotlinx.android.synthetic.main.category_new_arrivals_item.view.*

class CategoriesNewArrivalsRecyclerAdapter(private val newArrivalList: List<NewArrival>) :
    RecyclerView.Adapter<CategoriesNewArrivalsRecyclerAdapter.CategoriesNewArrivalItemHolder>() {

    var scrollDirection = ScrollDirection.LEFT

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesNewArrivalItemHolder {
        return CategoriesNewArrivalItemHolder(parent.inflate(R.layout.category_new_arrivals_item, false))
    }

    override fun getItemCount(): Int = newArrivalList.size


    override fun onBindViewHolder(holder: CategoriesNewArrivalItemHolder, position: Int) {
        holder.bind(newArrivalList[position])
    }

    inner class CategoriesNewArrivalItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(newArrival: NewArrival) {
            GlideApp.with(itemView.context)
                .load(newArrival.image)
                .into(this.itemView.categoryNewArrivalImageView)

            animateView(itemView)
        }
    }

    private fun animateView(viewToAnimate: View) {
        if (viewToAnimate.animation == null) {
            val animId =
                if (scrollDirection == ScrollDirection.LEFT) R.anim.slide_from_left else R.anim.slide_from_right
            val animation = AnimationUtils.loadAnimation(viewToAnimate.context, animId)
            viewToAnimate.animation = animation
        }
    }

    enum class ScrollDirection { LEFT, RIGHT }
}
