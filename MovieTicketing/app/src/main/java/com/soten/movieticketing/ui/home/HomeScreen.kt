package com.soten.movieticketing.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.soten.movieticketing.domain.models.Movie
import com.soten.movieticketing.ui.navigation.HomeNavigator

@Composable
fun HomeRoute(
    navigator: HomeNavigator,
) {
    HomeScreen(
        homeNavigator = navigator
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeNavigator: HomeNavigator,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val movies = homeViewModel.movies.collectAsLazyPagingItems()

    LazyColumn(
        modifier = modifier
    ) {
        items(movies.itemCount) { index ->
            MovieItem(movie = movies[index]!!,
                homeNavigator)
        }
    }
}

@Composable
fun MovieItem(
    movie: Movie,
    homeNavigator: HomeNavigator,
) {
    Column(Modifier.clickable {
        homeNavigator.navigateDetail(movie.movieCd)
    }) {
        Text(text = movie.movieNm)

        Text(text = movie.prdtYear)

        Text(text = "예매하기", modifier = Modifier.padding(bottom = 8.dp))
    }
}