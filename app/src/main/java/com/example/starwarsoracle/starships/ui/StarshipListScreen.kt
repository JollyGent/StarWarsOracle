package com.example.starwarsoracle.starships.ui

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
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.starwarsoracle.starships.StarshipItem


@Composable
fun StarshipListScreen() {
    val starshipListViewModel : StarshipListViewModel = hiltViewModel()
    val state by starshipListViewModel.state.collectAsState()

    /*When a sort by name/title button is pressed, it refreshes the list and orders them
    alphabetically. */
    val sorted = remember { mutableStateListOf<StarshipItem>()  }
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

                    items(sorted) { starship: StarshipItem ->
                        InfoCard(starship)
                    }

                }
            )
        }
    )
}



@Composable
fun InfoCard(starship: StarshipItem) {

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
                append("${starship.name}")
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
                append("${starship.model}")
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
                append("${starship.manufacturer}")
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
                append("${starship.costInCredits}")
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
                append("${starship.length}")
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
                append("${starship.crew}")
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
                append("${starship.passengers}")
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
                append("${starship.cargoCapacity}")
            },
            modifier = Modifier.padding(4.dp)
        )
    }
}