package dev.joseluis.mymoviescompose.views.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import dev.joseluis.mymoviescompose.R
import dev.joseluis.mymoviescompose.models.MediaItem
import dev.joseluis.mymoviescompose.models.getMediaItems
import dev.joseluis.mymoviescompose.views.shared.Thumb

@Composable
fun MediaList(navController: NavHostController, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(dimensionResource(id = R.dimen.cell_min_width)), // Variables  // GridCells.Fixed(2), // Celdas fijas
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_xsmall)),
        modifier = modifier
    ) {
        items(getMediaItems()) { item ->
            MediaListItem(
                item = item,
                navController = navController,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_xsmall))
            )
        }
    }
}

@Composable
fun MediaListItem(item: MediaItem, navController: NavHostController, modifier: Modifier = Modifier) {
    // Una columna
    Column(
        modifier = modifier
            .clickable { navController.navigate("detail/${item.id}") }) {
        Thumb(item)
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.secondary)
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            Text(
                text = item.title,
                fontSize = MaterialTheme.typography.h6.fontSize,
                fontWeight = MaterialTheme.typography.h6.fontWeight,
            )
        }
    }
}


/*
@Preview
@Composable
fun MediaListPreview() {
    MediaList(navController = navController)
}*/
