package com.xmo.list.spotdetails

import android.util.Log
import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.PRIVATE
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xmo.core.network.repositiories.OCMRepository
import com.xmo.list.spotdetails.model.SpotDetails
import com.xmo.list.spotdetails.model.SpotDetailsMapper
import kotlinx.coroutines.launch
import javax.inject.Inject

class SpotDetailsViewModel @Inject constructor(
    @VisibleForTesting(otherwise = PRIVATE)
    val ocmRepository: OCMRepository,
    @VisibleForTesting(otherwise = PRIVATE)
    val spotDetailsMapper: SpotDetailsMapper
) : ViewModel() {

    private val _data = MutableLiveData<SpotDetails>()
    val data: LiveData<SpotDetails>
        get() = _data

    private val _state = MutableLiveData<SpotDetailsViewState>()
    val state: LiveData<SpotDetailsViewState>
        get() = _state


    fun loadSpotDetails(spotId: Int) {
        _state.postValue(SpotDetailsViewState.Loading)
        viewModelScope.launch {
            try {
                val result = ocmRepository.getSpot(spotId)
                _data.postValue(spotDetailsMapper.map(result))
                _state.postValue(SpotDetailsViewState.Loaded)
                Log.d("xox", "loaded:$result")
            } catch (e: Exception) {
                _state.postValue(SpotDetailsViewState.Error)
                Log.d("xox",e.message.toString())
            }
        Log.d("xox","loaded?")

        }
    }


    fun dismissSpotDetails() {
        _state.postValue(SpotDetailsViewState.Dismiss)
    }
}
