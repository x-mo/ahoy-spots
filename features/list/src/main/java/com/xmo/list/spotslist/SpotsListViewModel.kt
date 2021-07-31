package com.xmo.list.spotslist

import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.PRIVATE
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xmo.core.database.spots.SpotRepository
import com.xmo.core.livedata.SingleLiveData
import com.xmo.core.network.repositiories.OCMRepository
import com.xmo.list.spotslist.model.SpotsItem
import com.xmo.list.spotslist.model.SpotsListFromDBMapper
import com.xmo.list.spotslist.model.SpotsListMapper
import com.xmo.list.spotslist.model.SpotsListToDBMapper
import kotlinx.coroutines.launch
import javax.inject.Inject

class SpotsListViewModel @Inject constructor(
    @VisibleForTesting(otherwise = PRIVATE)
    val ocmRepository: OCMRepository,
    @VisibleForTesting(otherwise = PRIVATE)
    val spotRepository: SpotRepository,
    @VisibleForTesting(otherwise = PRIVATE)
    val spotsListFromDBMapper: SpotsListFromDBMapper,
    @VisibleForTesting(otherwise = PRIVATE)
    val spotsListToDBMapper: SpotsListToDBMapper
) : ViewModel() {

    private val _data = MutableLiveData<List<SpotsItem>>()
    val data: LiveData<List<SpotsItem>>
        get() = _data

    private val _state = MutableLiveData<SpotsListViewState>()
    val state: LiveData<SpotsListViewState>
        get() = _state


    fun loadSpotsList(lat: Double, lng: Double) {
        _state.postValue(SpotsListViewState.Loading)

        viewModelScope.launch {
            try {
                // post spots from DB to view
                _data.postValue(spotsListFromDBMapper.map(spotRepository.getAllSpots()))
                // get fresh spots
                val result = ocmRepository.getSpots(lat = lat, lng = lng)
                // update spots in DB
                spotRepository.updateSpots(spotsListToDBMapper.map(result))
                // update spots in view
                _data.postValue(spotsListFromDBMapper.map(spotRepository.getAllSpots()))
            } catch (e: Exception) {
                _state.postValue(SpotsListViewState.Error)
            }
        }
    }


    fun dismissSpotsList() {
        _state.postValue(SpotsListViewState.Dismiss)
    }

}
