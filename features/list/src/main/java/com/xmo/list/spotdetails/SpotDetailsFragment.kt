package com.xmo.list.spotdetails

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.xmo.core.base.BaseFragment
import com.xmo.core.extensions.observe
import com.xmo.list.R
import com.xmo.list.databinding.FragmentSpotDetailsBinding
import com.xmo.list.spotdetails.di.DaggerSpotDetailsComponent
import com.xmo.list.spotdetails.di.SpotDetailsModule
import com.xmo.list.spotdetails.model.SpotDetails
import com.xmo.spots.BaseApp.Companion.coreComponent
import javax.inject.Inject
import android.content.Intent




class SpotDetailsFragment :
    BaseFragment<FragmentSpotDetailsBinding, SpotDetailsViewModel>(
        layoutId = R.layout.fragment_spot_details
    ) {

    @Inject
    lateinit var progressDialog: ProgressBar

    private val args: SpotDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(viewModel.state, ::onViewStateChange)

        viewModel.loadSpotDetails(args.spotId)

        observe(viewModel.data) {
            viewBinding.spot = it
        }
    }

    override fun onInitDependencyInjection() {
        DaggerSpotDetailsComponent
            .builder()
            .coreComponent(coreComponent(requireContext()))
            .spotDetailsModule(SpotDetailsModule(this))
            .build()
            .inject(this)
    }

    override fun onInitDataBinding() {
        viewBinding.viewModel = viewModel
    }


    private fun onViewStateChange(viewState: SpotDetailsViewState) {
        when (viewState) {
            is SpotDetailsViewState.Loading ->
                progressDialog.visibility = VISIBLE
            is SpotDetailsViewState.Error ->
                progressDialog.visibility = VISIBLE //show error drawable
            is SpotDetailsViewState.Dismiss ->
                findNavController().navigateUp()
            else -> progressDialog.visibility = GONE
        }
    }
}