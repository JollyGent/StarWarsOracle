package com.example.starwarsoracle.domain

import com.example.starwarsoracle.films.data.model.FilmItem
import com.example.starwarsoracle.starships.StarshipItem
import com.example.starwarsoracle.vehicles.VehicleItem

interface StarWarsRepository {

    suspend fun getFilms() : List<FilmItem>

    suspend fun getVehicles() : List<VehicleItem>

    suspend fun getStarships() : List<StarshipItem>
}