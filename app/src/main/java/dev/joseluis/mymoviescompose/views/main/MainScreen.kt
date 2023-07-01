package dev.joseluis.mymoviescompose.views.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        topBar = { MainAppBar() }
    ) { padding ->
        MediaList(navController = navController, modifier = Modifier.padding(padding))
    }
}

/*
@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(navController)
}*/
