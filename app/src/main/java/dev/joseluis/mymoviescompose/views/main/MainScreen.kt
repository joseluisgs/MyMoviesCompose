package dev.joseluis.mymoviescompose.views.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen() {
    Scaffold(
        topBar = { MainAppBar() }
    ) { padding ->
        MediaList(modifier = Modifier.padding(padding))
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}