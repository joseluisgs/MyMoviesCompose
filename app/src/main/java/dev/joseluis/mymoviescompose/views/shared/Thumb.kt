package dev.joseluis.mymoviescompose.views.shared

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import coil.compose.AsyncImage
import dev.joseluis.mymoviescompose.R
import dev.joseluis.mymoviescompose.models.MediaItem

@Composable
fun Thumb(item: MediaItem, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
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
}