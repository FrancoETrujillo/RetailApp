package com.mvatech.ftrujillo.abfclone.features.shop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvatech.ftrujillo.abfclone.R
import com.mvatech.ftrujillo.abfclone.features.shop.ui.adapters.categories.NewArrivalsRecyclerAdapter
import com.mvatech.ftrujillo.abfclone.features.shop.viewmodels.CategoriesViewModel
import kotlinx.android.synthetic.main.category_list_new_arrivals.*

class CategoriesFragment : Fragment() {

    private lateinit var viewModel: CategoriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.categories_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CategoriesViewModel::class.java)

        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        categoriesNewArrivalsRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = NewArrivalsRecyclerAdapter(viewModel.getNewArrivals())

        }. also {
//            it.addItemDecoration(
//                DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL)
//            )
        }
    }

}
