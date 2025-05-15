package com.example.starwarsoracle.starships.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarsoracle.domain.StarWarsRepository
import com.example.starwarsoracle.starships.StarshipItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class StarshipListViewModel @Inject constructor(
    private val starWarsRepository: StarWarsRepository
) : ViewModel(){

    private val _state = MutableStateFlow(emptyList<StarshipItem>())
    val state : StateFlow<List<StarshipItem>>
        get() = _state

    //observe the data
    init {
        viewModelScope.launch {
            val starships = starWarsRepository.getStarships()
            _state.value = starships
        }
    }

}