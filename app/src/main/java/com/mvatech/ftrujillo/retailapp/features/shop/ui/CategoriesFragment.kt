package com.mvatech.ftrujillo.retailapp.features.shop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvatech.ftrujillo.retailapp.R
import com.mvatech.ftrujillo.retailapp.features.shop.ui.adapters.categories.CategoriesRecyclerAdapter
import com.mvatech.ftrujillo.retailapp.features.shop.viewmodels.CategoriesViewModel
import kotlinx.android.synthetic.main.categories_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class CategoriesFragment : Fragment() {

    private val viewModel by viewModel<CategoriesViewModel>()
    private lateinit var contentAdapter:CategoriesRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.categories_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()
        setUpLiveData()
        updateContent()
    }

    private fun updateContent() {
        progressBar_loading.visibility = View.VISIBLE
        viewModel.updateContent()
    }

    private fun setUpLiveData() {
        viewModel.categoriesContent.observe(this, onCategoriesTabContentReceived)
    }

    private val onCategoriesTabContentReceived = Observer<List<Any>> {
        progressBar_loading.visibility = View.GONE
        contentAdapter.updateData(it)
    }

    private fun setupRecyclerView() {
        contentAdapter = CategoriesRecyclerAdapter()
        categoriesParentRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = contentAdapter
        }
    }

}
