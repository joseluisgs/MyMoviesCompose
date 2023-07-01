package dev.joseluis.mymoviescompose.views.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.joseluis.mymoviescompose.models.MediaItem

@Composable
fun MainScreen(onMediaClick: (MediaItem) -> Unit) {
    Scaffold(
        topBar = { MainAppBar() }
    ) { padding ->
        MediaList(
            onMediaClick = onMediaClick,
            modifier = Modifier.padding(padding)
        )
    }
}

/*
@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(navController)
}*/
