package com.mvatech.ftrujillo.abfclone.features.shop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvatech.ftrujillo.abfclone.R
import com.mvatech.ftrujillo.abfclone.features.shop.ui.adapters.categories.CategoriesRecyclerAdapter
import com.mvatech.ftrujillo.abfclone.features.shop.viewmodels.CategoriesViewModel
import kotlinx.android.synthetic.main.categories_fragment.*
import timber.log.Timber

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

        setUpLiveData()
    }

    private fun setUpLiveData() {
        viewModel.getCategoriesContent().observe(this, onCategoriesTabContentReceived)
    }

    private val onCategoriesTabContentReceived = Observer<List<Any>> {
        Timber.d("Franco livedata %s", it.toString())
        setupRecyclerView(it)
    }

    private fun setupRecyclerView(list: List<Any>) {
        categoriesParentRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = CategoriesRecyclerAdapter(list)

        }
    }

}
