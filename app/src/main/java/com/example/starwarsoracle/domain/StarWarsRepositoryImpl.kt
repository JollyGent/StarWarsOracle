package com.example.starwarsoracle.domain


import com.example.starwarsoracle.api.StarWarsApiService
import com.example.starwarsoracle.films.data.model.FilmItem
import com.example.starwarsoracle.starships.StarshipItem
import com.example.starwarsoracle.vehicles.VehicleItem
import javax.inject.Inject

class StarWarsRepositoryImpl @Inject constructor(
    private val starWarsApi : StarWarsApiService
) : StarWarsRepository {

    override suspend fun getFilms() : List<FilmItem> {
        return starWarsApi.getFilms()
    }

    override suspend fun getVehicles() : List<VehicleItem> {
        return starWarsApi.getVehicles()
    }

    override suspend fun getStarships(): List<StarshipItem> {
        return starWarsApi.getStarships()
    }
}