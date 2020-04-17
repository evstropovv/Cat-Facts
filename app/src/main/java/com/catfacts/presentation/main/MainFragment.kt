package com.catfacts.presentation.main

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.catfacts.App
import com.catfacts.R
import com.catfacts.di.ViewModelFactory
import com.catfacts.library_base.presentation.extention.visible
import com.catfacts.library_base.presentation.fragment.BaseContainerFragment
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject

class MainFragment : BaseContainerFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    @Inject
    lateinit var factory: ViewModelFactory

    private lateinit var viewModel: MainViewModel

    override val layoutResourceId: Int = R.layout.main_fragment

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.application as App).getComponent()?.inject(this)
        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.stateLiveData.observe(viewLifecycleOwner,
            Observer<MainViewModel.ViewState> {
                progressBar.visible(it.isLoading)

                message.text = it.catFact.fact

                Glide.with(this)
                    .load(it.catFact.pictureUrl)
                    .into(imageView)
            })

        initClickListeners()
        viewModel.loadData()
    }


    private fun initClickListeners() {
        btnLoadNext.setOnClickListener {
            viewModel.loadNextFact()
        }
    }

}