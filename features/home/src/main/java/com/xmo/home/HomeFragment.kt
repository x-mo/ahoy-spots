package com.xmo.home

import android.os.Bundle
import android.view.*
import com.xmo.core.base.BaseFragment
import com.xmo.home.databinding.FragmentHomeBinding
import com.xmo.home.di.DaggerHomeComponent
import com.xmo.home.di.HomeModule
import com.xmo.spots.App

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    layoutId = R.layout.fragment_home
) {


    private val navGraphIds = listOf(
        R.navigation.navigation_spots_list_graph/*,
        R.navigation.navigation_settings_graph*/
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()

    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        /*setupBottomNavigationBar()*/
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.toolbar_menu, menu)
    }

    override fun onInitDependencyInjection() {
        DaggerHomeComponent
            .builder()
            .coreComponent(App.coreComponent(requireContext()))
            .homeModule(HomeModule(this))
            .build()
            .inject(this)
    }


    override fun onInitDataBinding() {
        viewBinding.viewModel = viewModel
    }


    private fun setupToolbar() {
        setHasOptionsMenu(true)
    }

    /*private fun setupBottomNavigationBar() {
        val navController = viewBinding.bottomNavigation.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = childFragmentManager,
            containerId = R.id.nav_host_container,
            intent = requireActivity().intent
        )

        navController.observe(
            viewLifecycleOwner,
            Observer {
                viewModel.navigationControllerChanged(it)
                setupActionBarWithNavController(requireCompatActivity(), it)
            }
        )
    }*/
}