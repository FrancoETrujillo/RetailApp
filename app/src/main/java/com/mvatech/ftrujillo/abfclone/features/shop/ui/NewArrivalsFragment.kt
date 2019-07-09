package com.mvatech.ftrujillo.abfclone.features.shop.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mvatech.ftrujillo.abfclone.R
import com.mvatech.ftrujillo.abfclone.features.shop.viewmodels.NewArrivalsViewModel

class NewArrivalsFragment : Fragment() {

    companion object {
        fun newInstance() = NewArrivalsFragment()
    }

    private lateinit var viewModel: NewArrivalsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.new_arrivals_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NewArrivalsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
