package dev.joseluis.mymoviescompose.views.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import dev.joseluis.mymoviescompose.models.getMediaItems
import dev.joseluis.mymoviescompose.views.shared.ArrowBackIcon
import dev.joseluis.mymoviescompose.views.shared.Thumb


@Composable
fun DetailScreen(movieId: Int, onUpClick: () -> Unit) {
    val mediaItem = remember { getMediaItems().first { it.id == movieId } }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = mediaItem.title) },
                navigationIcon = { ArrowBackIcon(onUpClick) }
            )
        }
    ) { padding ->
        Thumb(item = mediaItem, modifier = Modifier.padding(padding))
    }
}

/*
@Preview(showBackground = true, widthDp = 400, heightDp = 400)
@Composable
fun PreviewDetailScreen() {
    DetailScreen(backStackEntry.arguments?.getInt("movieId") ?: 0)
}*/
