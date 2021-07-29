package com.xmo.home

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.xmo.home.databinding.FragmentHomeBinding
import com.xmo.home.di.DaggerHomeComponent
import com.xmo.home.di.HomeModule
import com.xmo.spots.App
import javax.inject.Inject

private const val DELAY_TO_APPLY_THEME = 1000L

class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModel: HomeViewModel
    lateinit var viewBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewBinding.lifecycleOwner = viewLifecycleOwner
        return viewBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onInitDependencyInjection()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInitDataBinding()
    }


    private fun onInitDependencyInjection() {
        DaggerHomeComponent
            .builder()
            .coreComponent(App.coreComponent(requireContext()))
            .homeModule(HomeModule(this))
            .build()
            .inject(this)
    }

    private fun onInitDataBinding() {
        viewBinding.viewModel = viewModel
    }
}
