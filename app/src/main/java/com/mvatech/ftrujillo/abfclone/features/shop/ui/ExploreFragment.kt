package com.mvatech.ftrujillo.abfclone.features.shop.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.mvatech.ftrujillo.abfclone.R
import com.mvatech.ftrujillo.abfclone.features.shop.data.models.Promotion
import com.mvatech.ftrujillo.abfclone.features.shop.ui.adapters.categories.CategoriesRecyclerAdapter
import com.mvatech.ftrujillo.abfclone.features.shop.ui.adapters.explore.PromotionsListAdapter
import com.mvatech.ftrujillo.abfclone.features.shop.viewmodels.ExploreViewModel
import kotlinx.android.synthetic.main.categories_fragment.*
import kotlinx.android.synthetic.main.categories_fragment.progressBar_loading
import kotlinx.android.synthetic.main.explore_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class ExploreFragment : Fragment() {

    private val viewModel by viewModel<ExploreViewModel>()
    private lateinit var contentAdapter:PromotionsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.explore_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setUpLiveData()
        setupRecyclerView()
        updateContent()
    }

    private fun updateContent() {
        progressBar_loading.visibility = View.VISIBLE
        viewModel.updateContent()
    }

    private fun setUpLiveData() {
        viewModel.exploreContent.observe(this, onExploreContentReceived)
    }

    private val onExploreContentReceived = Observer<List<Promotion>> {
        progressBar_loading.visibility = View.GONE
        contentAdapter.updateData(it)
    }

    private fun setupRecyclerView() {
        contentAdapter = PromotionsListAdapter()
        promotionsRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = contentAdapter

        }
    }
}
