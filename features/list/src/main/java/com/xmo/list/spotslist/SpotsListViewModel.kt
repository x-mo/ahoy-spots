package com.xmo.list.spotslist

import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.PRIVATE
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xmo.core.network.repositiories.OCMRepository
import com.xmo.list.spotslist.model.SpotsList
import com.xmo.list.spotslist.model.SpotsListMapper
import kotlinx.coroutines.launch
import javax.inject.Inject

class SpotsListViewModel @Inject constructor(
    @VisibleForTesting(otherwise = PRIVATE)
    val ocmRepository: OCMRepository,
    @VisibleForTesting(otherwise = PRIVATE)
    val spotsListMapper: SpotsListMapper
) : ViewModel() {

    private val _data = MutableLiveData<SpotsList>()
    val data: LiveData<SpotsList>
        get() = _data

    private val _state = MutableLiveData<SpotsListViewState>()
    val state: LiveData<SpotsListViewState>
        get() = _state


    fun loadSpotsList(spotId: Int) {
        _state.postValue(SpotsListViewState.Loading)
        viewModelScope.launch {
            try {
                val result = ocmRepository.getSpot(spotId)
                _data.postValue(spotsListMapper.map(result))

            } catch (e: Exception) {
                _state.postValue(SpotsListViewState.Error)
            }
        }
    }


    fun dismissSpotsList() {
        _state.postValue(SpotsListViewState.Dismiss)
    }
}
