package com.xmo.list.spotslist

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.navigation.fragment.findNavController
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.permissionx.guolindev.PermissionX
import com.xmo.core.base.BaseFragment
import com.xmo.core.extensions.observe
import com.xmo.list.R
import com.xmo.list.databinding.FragmentSpotListBinding
import com.xmo.list.spotslist.di.DaggerSpotsListComponent
import com.xmo.list.spotslist.di.SpotsListModule
import com.xmo.spots.BaseApp
import javax.inject.Inject

private const val LOCATION_PERMISSION_REQUEST_CODE: Int = 3193

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

        requestLocationPermissionAndObtainLatLng()

        observe(viewModel.data) { Log.d("xox", it.toString()) }
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

//--------!!!Refactor This Later!!!---------------------------------------------------------------------------------------------
    private fun requestLocationPermissionAndObtainLatLng() {
        PermissionX.init(this)
            .permissions(Manifest.permission.ACCESS_FINE_LOCATION)
            .onExplainRequestReason { scope, deniedList ->
                scope.showRequestReasonDialog(
                    deniedList, getString(R.string.spots_only_available_if), getString(
                        R.string.ok
                    ), getString(R.string.cancel)
                )
            }
            .request { allGranted, _, _ ->
                if (allGranted) {
                    setUpLocationListener()
                } else {
                    Toast.makeText(
                        activity,
                        getString(R.string.location_denied_app),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
    }

    @SuppressLint("MissingPermission")
    private fun setUpLocationListener() {
        val fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireActivity())

        // for getting the current location update after every 2 seconds with high accuracy
        val locationRequest = LocationRequest.create().apply {
            interval = 2000
            fastestInterval = 50
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            maxWaitTime = 2000
        }
        fusedLocationProviderClient.requestLocationUpdates(
            locationRequest,
            object : LocationCallback() {
                override fun onLocationResult(locationResult: LocationResult) {
                    super.onLocationResult(locationResult)
                    for (location in locationResult.locations) {

                        viewModel.loadSpotsList(location.latitude, location.longitude)
                        Log.d("lat---", location.latitude.toString())
                        Log.d("lng---", location.longitude.toString())
                        //stop location updates
                        fusedLocationProviderClient.removeLocationUpdates(this);

                    }
                }
            },
            Looper.myLooper()
        )
    }

}