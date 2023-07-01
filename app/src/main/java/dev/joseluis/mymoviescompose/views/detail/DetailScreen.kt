package dev.joseluis.mymoviescompose.views.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import dev.joseluis.mymoviescompose.models.getMediaItems
import dev.joseluis.mymoviescompose.views.shared.Thumb


@Composable
fun DetailScreen(movieId: Int) {
    val mediaItem = remember { getMediaItems().first { it.id == movieId } }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = mediaItem.title) },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
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
