package com.example.starwarsoracle.api

import com.example.starwarsoracle.films.data.model.FilmItem
import com.example.starwarsoracle.starships.StarshipItem
import com.example.starwarsoracle.utils.Constants
import com.example.starwarsoracle.vehicles.VehicleItem
import retrofit2.http.GET


interface StarWarsApiService {

    @GET(Constants.FILMS)
    suspend fun getFilms() : List<FilmItem>

    @GET(Constants.VEHICLES)
    suspend fun getVehicles() : List<VehicleItem>

    @GET(Constants.STAR_SHIPS)
    suspend fun getStarships() : List<StarshipItem>
}