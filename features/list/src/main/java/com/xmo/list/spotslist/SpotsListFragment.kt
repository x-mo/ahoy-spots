package com.xmo.list.spotslist

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.navigation.fragment.findNavController
import com.xmo.core.base.BaseFragment
import com.xmo.core.extensions.observe
import com.xmo.list.R
import com.xmo.list.databinding.FragmentSpotListBinding
import com.xmo.list.spotslist.di.DaggerSpotsListComponent
import com.xmo.list.spotslist.di.SpotsListModule
import com.xmo.spots.BaseApp
import javax.inject.Inject

class SpotsListFragment :
    BaseFragment<FragmentSpotListBinding, SpotsListViewModel>(
        layoutId = R.layout.fragment_spot_list
    ) {

    @Inject
    lateinit var progressDialog: ProgressBar

    /*private val args: SpotsListFragmentArgs by navArgs()*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(viewModel.state, ::onViewStateChange)
        viewModel.loadSpotsList(99851)

        observe(viewModel.data) { Log.d("xox", it.generalComments) }
    }

    override fun onInitDependencyInjection() {
        DaggerSpotsListComponent
            .builder()
            .coreComponent(BaseApp.coreComponent(requireContext()))
            .spotsListModule(SpotsListModule(this))
            .build()
            .inject(this)
    }

    override fun onInitDataBinding() {
        viewBinding.viewModel = viewModel
    }


    private fun onViewStateChange(viewState: SpotsListViewState) {
        when (viewState) {
            is SpotsListViewState.Loading ->
                progressDialog.visibility = View.VISIBLE
            is SpotsListViewState.Error ->
                progressDialog.visibility = View.VISIBLE //show error drawable
            is SpotsListViewState.Dismiss ->
                findNavController().navigateUp()
            else -> progressDialog.visibility = View.GONE
        }
    }
}