package com.example.starwarsoracle.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.starwarsoracle.navigation.NavigationRoute
import com.example.starwarsoracle.utils.Constants

@Composable
fun HomeScreen(navController: NavController) {
    var search by remember { mutableStateOf("") }

    var searchError by remember { mutableStateOf("") }

    Column (
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Star Wars Oracle",
            modifier = Modifier.padding(4.dp),
            fontSize = 30.sp,
            fontWeight =  FontWeight.Bold,
            color = Color.Yellow)

        Text(text = "Your little Garindan to the Canon Universe.",
            modifier = Modifier.padding(4.dp),
            fontSize = 12.sp,
            fontStyle = FontStyle.Italic,
            color = Color.Yellow)

        TextField(
            value = search,
            onValueChange = {search = it},
            label = {
                Text(
                    searchError.ifEmpty { "Enter a keyword..." },
                    color = if(searchError.isNotEmpty()) Color.Red else Color.Yellow)
            },
            placeholder = {
                Text("Films, vehicles, or...starships!")
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent
            )
        )
        Button(

            colors = ButtonDefaults.buttonColors(Color.Yellow),

            //Put the textfield in lowercase, remove whitespaces and then check whether it's a valid endpoint.
            onClick = {
                if(search.lowercase().filter { !it.isWhitespace() } == Constants.FILMS) {
                    navController.navigate(NavigationRoute.FilmListScreen.route)
                }
                else if(search.lowercase().filter { !it.isWhitespace() } == Constants.STAR_SHIPS) {
                    navController.navigate(NavigationRoute.StarshipListScreen.route)
                }
                else if(search.lowercase().filter { !it.isWhitespace() } == Constants.VEHICLES) {
                    navController.navigate(NavigationRoute.VehicleListScreen.route)
                }
                else {
                    searchError = "It's a Trap! - invalid keyword!"
                }
            }
        ) {
            Text("Search", color = Color.Black)
        }
    }

}
