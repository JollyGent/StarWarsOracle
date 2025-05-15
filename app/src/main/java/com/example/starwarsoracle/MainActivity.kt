package com.example.starwarsoracle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.starwarsoracle.films.ui.FilmListScreen
import com.example.starwarsoracle.films.ui.VehicleListScreen
import com.example.starwarsoracle.navigation.NavigationRoute
import com.example.starwarsoracle.starships.ui.StarshipListScreen
import com.example.starwarsoracle.ui.home.HomeScreen
import com.example.starwarsoracle.ui.theme.StarWarsOracleTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            StarWarsOracleTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    //Navigation host is declared here.
                    NavHost(navController = navController, startDestination = NavigationRoute.HomeScreen.route) {
                        composable(route = NavigationRoute.HomeScreen.route) {
                            HomeScreen(navController)
                        }
                        composable(route = NavigationRoute.FilmListScreen.route) {
                            FilmListScreen()
                        }
                        composable(route = NavigationRoute.VehicleListScreen.route) {
                            VehicleListScreen()
                        }
                        composable(route = NavigationRoute.StarshipListScreen.route) {
                            StarshipListScreen()
                        }
                    }
                }
                }
            }
        }
    }
