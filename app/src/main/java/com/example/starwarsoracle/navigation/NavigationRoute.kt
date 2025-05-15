package com.example.starwarsoracle.navigation

sealed class NavigationRoute (val route: String) {

    object HomeScreen : NavigationRoute("home_screen")
    object FilmListScreen : NavigationRoute("film_list_screen")
    object VehicleListScreen : NavigationRoute("vehicle_list_screen")
    object StarshipListScreen : NavigationRoute("starship_list_screen")

}