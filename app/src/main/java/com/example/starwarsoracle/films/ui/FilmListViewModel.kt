package com.example.starwarsoracle.films.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarsoracle.domain.StarWarsRepository
import com.example.starwarsoracle.films.data.model.FilmItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FilmListViewModel @Inject constructor(
    private val starWarsRepository: StarWarsRepository
) : ViewModel(){

    private val _state = MutableStateFlow(emptyList<FilmItem>())
    val state : StateFlow<List<FilmItem>>
        get() = _state

    //observe the data
    init {
        viewModelScope.launch {
            val films = starWarsRepository.getFilms()
            _state.value = films
        }
    }

}