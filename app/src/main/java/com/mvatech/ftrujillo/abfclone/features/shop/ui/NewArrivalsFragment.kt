package com.mvatech.ftrujillo.abfclone.features.shop.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager

import com.mvatech.ftrujillo.abfclone.R
import com.mvatech.ftrujillo.abfclone.features.shop.data.models.NewArrival
import com.mvatech.ftrujillo.abfclone.features.shop.ui.adapters.categories.NewArrivalsRecyclerAdapter
import com.mvatech.ftrujillo.abfclone.features.shop.ui.adapters.new_arrivals.NewArrivalsAdapter
import com.mvatech.ftrujillo.abfclone.features.shop.viewmodels.NewArrivalsViewModel
import kotlinx.android.synthetic.main.new_arrivals_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class NewArrivalsFragment : Fragment() {

    private val viewModel by viewModel<NewArrivalsViewModel>()
    private lateinit var newArrivalsAdapter: NewArrivalsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.new_arrivals_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setUpLiveData()
        setUpViews()
        viewModel.updateData()
    }

    private fun setUpLiveData() {
        viewModel.newArrivalsContent.observe(this, onNewArrivalsListChanged)
    }

    private fun setUpViews() {
        newArrivalsAdapter = NewArrivalsAdapter()
        newArrivalsRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = newArrivalsAdapter
        }
    }

    private val onNewArrivalsListChanged = Observer<List<NewArrival>>{
       newArrivalsAdapter.updateData(it)

    }

}
