package dev.joseluis.mymoviescompose.views.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import dev.joseluis.mymoviescompose.R
import dev.joseluis.mymoviescompose.models.MediaItem
import dev.joseluis.mymoviescompose.models.getMediaItems

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
            .clickable { navController.navigate("detail") }) {
        Box(
            modifier = Modifier
                .height(dimensionResource(id = R.dimen.cell_thumb_height))
        ) {
            // Aquí irán las dos images
            // Imagen con Coil
            AsyncImage(
                model = item.thumb, contentDescription = "Image 1",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
            if (item.type == MediaItem.Type.VIDEO) {
                // Iconos desde Material Design
                Icon(
                    imageVector = Icons.Default.PlayCircleOutline,
                    contentDescription = "Play",
                    tint = Color.White.copy(alpha = 0.6f),
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.cell_play_icon_size))
                        //.clip(RoundedCornerShape(92.dp))
                        //.background(Color.Black.copy(alpha = 0.5f))
                        .align(Alignment.Center)
                )
            }
        }
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
