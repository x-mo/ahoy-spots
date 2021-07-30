package com.xmo.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController


//val NAV_FRAGMENTS_ID = setOf(R.id.spots_list_fragment, R.id.settings_fragment)
val NAV_FRAGMENTS_ID = setOf(R.id.spots_list_fragment/*, R.id.home_fragment*/)

class HomeViewModel : ViewModel() {
    private val _state = MutableLiveData<HomeViewState>()
    val state: LiveData<HomeViewState>
        get() = _state



    fun navigationControllerChanged(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (NAV_FRAGMENTS_ID.contains(destination.id)) {
                _state.postValue(HomeViewState.NavigationScreen)
            } else {
                _state.postValue(HomeViewState.FullScreen)
            }
        }
    }


}
