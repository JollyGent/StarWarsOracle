package com.example.starwarsoracle.films.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.starwarsoracle.vehicles.VehicleItem
import com.example.starwarsoracle.vehicles.ui.VehicleListViewModel

@Composable
fun VehicleListScreen() {
    val vehicleListViewModel : VehicleListViewModel = hiltViewModel()
    val state by vehicleListViewModel.state.collectAsState()

    /*When a sort by name/title button is pressed, it refreshes the list and orders them
    alphabetically. */
    val sorted = remember { mutableStateListOf<VehicleItem>()  }
    sorted.addAll(state)

    Column(
        modifier = Modifier.padding(32.dp),
        content = {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Top,
                modifier = Modifier.fillMaxWidth(),
                content = {
                    Button(
                        modifier = Modifier.padding(4.dp),
                        shape = RoundedCornerShape(10.dp),
                        elevation = ButtonDefaults.buttonElevation(4.dp),
                        colors = ButtonDefaults.buttonColors(Color.Yellow),
                        onClick = {
                            sorted.clear()
                            sorted.addAll(state.sortedBy { it.name })
                        }
                    ) {
                        Text("Sort by Name", color = Color.Black)
                    }
                    Button(
                        modifier = Modifier.padding(4.dp),
                        shape = RoundedCornerShape(10.dp),
                        elevation = ButtonDefaults.buttonElevation(4.dp),
                        colors = ButtonDefaults.buttonColors(Color.Yellow),
                        onClick = {
                            sorted.clear()
                            sorted.addAll(state)
                        }
                    ) {
                        Text("Sort by Default", color = Color.Black)
                    }

                }
            )

            LazyColumn(
                modifier = Modifier.fillMaxHeight().fillMaxWidth(),
                content = {
                    if (state.isEmpty()) {
                        item {
                            CircularProgressIndicator(
                                modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center)
                            )
                        }
                    }

                    items(sorted) { vehicle: VehicleItem ->
                        InfoCard(vehicle)
                    }

                }
            )
        }
    )
}



@Composable
fun InfoCard(vehicle: VehicleItem) {

    Card(elevation = CardDefaults.cardElevation(
        defaultElevation = 6.dp
    ), shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            buildAnnotatedString {
                withStyle(
                    style= SpanStyle(fontWeight = FontWeight.Bold)
                ) {
                    append("Name: ")
                }
                append("${vehicle.name}")
            },
            modifier = Modifier.padding(4.dp)
        )
        Text(
            buildAnnotatedString {
                withStyle(
                    style= SpanStyle(fontWeight = FontWeight.Bold)
                ) {
                    append("Model: ")
                }
                append("${vehicle.model}")
            },
            modifier = Modifier.padding(4.dp)
        )
        Text(
            buildAnnotatedString {
                withStyle(
                    style= SpanStyle(fontWeight = FontWeight.Bold)
                ) {
                    append("Manufacturer: ")
                }
                append("${vehicle.manufacturer}")
            },
            modifier = Modifier.padding(4.dp)
        )
        Text(
            buildAnnotatedString {
                withStyle(
                    style= SpanStyle(fontWeight = FontWeight.Bold)
                ) {
                    append("Cost in credits: ")
                }
                append("${vehicle.costInCredits}")
            },
            modifier = Modifier.padding(4.dp)
        )

        Text(
            buildAnnotatedString {
                withStyle(
                    style= SpanStyle(fontWeight = FontWeight.Bold)
                ) {
                    append("Length: ")
                }
                append("${vehicle.length}")
            },
            modifier = Modifier.padding(4.dp)
        )

        Text(
            buildAnnotatedString {
                withStyle(
                    style= SpanStyle(fontWeight = FontWeight.Bold)
                ) {
                    append("Crew: ")
                }
                append("${vehicle.crew}")
            },
            modifier = Modifier.padding(4.dp)
        )

        Text(
            buildAnnotatedString {
                withStyle(
                    style= SpanStyle(fontWeight = FontWeight.Bold)
                ) {
                    append("Passengers: ")
                }
                append("${vehicle.passengers}")
            },
            modifier = Modifier.padding(4.dp)
        )

        Text(
            buildAnnotatedString {
                withStyle(
                    style= SpanStyle(fontWeight = FontWeight.Bold)
                ) {
                    append("Cargo capacity: ")
                }
                append("${vehicle.cargoCapacity}")
            },
            modifier = Modifier.padding(4.dp)
        )
    }
}