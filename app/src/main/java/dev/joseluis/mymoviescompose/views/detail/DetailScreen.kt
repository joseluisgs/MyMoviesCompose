package dev.joseluis.mymoviescompose.views.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DetailScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Detail Screen",
            style = MaterialTheme.typography.h4

        )
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 400)
@Composable
fun PreviewDetailScreen() {
    DetailScreen()
}