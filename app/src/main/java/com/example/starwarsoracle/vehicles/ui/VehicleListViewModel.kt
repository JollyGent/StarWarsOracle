package com.example.starwarsoracle.vehicles.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarsoracle.domain.StarWarsRepository
import com.example.starwarsoracle.vehicles.VehicleItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class VehicleListViewModel @Inject constructor(
    private val starWarsRepository: StarWarsRepository
) : ViewModel(){

    private val _state = MutableStateFlow(emptyList<VehicleItem>())
    val state : StateFlow<List<VehicleItem>>
        get() = _state

    //observe the data
    init {
        viewModelScope.launch {
            val vehicles = starWarsRepository.getVehicles()
            _state.value = vehicles
        }
    }

}