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
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.starwarsoracle.R
import com.example.starwarsoracle.films.data.model.FilmItem


@Composable
fun FilmListScreen() {
    val filmListViewModel : FilmListViewModel = hiltViewModel()
    val state by filmListViewModel.state.collectAsState()


    /*When a sort by name/title button is pressed, it refreshes the list and orders them
    alphabetically. */
    val sorted = remember { mutableStateListOf<FilmItem>()  }
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
                            sorted.addAll(state.sortedBy { it.title })
                        }
                    ) {
                        Text(stringResource(R.string.sort_by_title), color = Color.Black)
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
                        Text(stringResource(R.string.sort_by_default), color = Color.Black)
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

                    items(sorted) { film: FilmItem ->
                        InfoCard(film)
                    }

                }
            )
        }
    )
}



@Composable
fun InfoCard(film : FilmItem) {

    val filmStrings = stringArrayResource(R.array.film_tags)

    Card(elevation = CardDefaults.cardElevation(
        defaultElevation = 6.dp
    ), shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "${film.title}", modifier = Modifier.padding(4.dp), fontSize = 25.sp, fontWeight =  FontWeight.Bold)
        Text(
            buildAnnotatedString {
                withStyle(
                    style= SpanStyle(fontWeight = FontWeight.Bold)
                    ) {
                    append(filmStrings[0])
                }
                    append("${film.episodeId}")
            },
                    modifier = Modifier.padding(4.dp)
        )
        Text(
            buildAnnotatedString {
                withStyle(
                    style= SpanStyle(fontWeight = FontWeight.Bold)
                ) {
                    append(filmStrings[1])
                }
                append("${film.director}")
            },
            modifier = Modifier.padding(4.dp)
        )
        Text(
            buildAnnotatedString {
                withStyle(
                    style= SpanStyle(fontWeight = FontWeight.Bold)
                ) {
                    append(filmStrings[2])
                }
                append("${film.producer}")
            },
            modifier = Modifier.padding(4.dp)
        )
        Text(
            buildAnnotatedString {
                withStyle(
                    style= SpanStyle(fontWeight = FontWeight.Bold)
                ) {
                    append(filmStrings[3])
                }
                append("${film.releaseDate}")
            },
            modifier = Modifier.padding(4.dp)
        )
        Text(text = "\n${film.openingCrawl}", modifier = Modifier.padding(4.dp))
    }
}

