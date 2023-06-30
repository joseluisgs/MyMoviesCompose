package dev.joseluis.mymoviescompose.views.main

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.joseluis.mymoviescompose.R

@Composable
fun MainAppBar() {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name)) },
        actions = {
            MainAppActionItem(imageVector = Icons.Filled.Search, description = "Buscar", onClick = { /*TODO*/ })
            MainAppActionItem(imageVector = Icons.Filled.Share, description = "Compartir", onClick = { /*TODO*/ })
        }
    )
}

@Composable
private fun MainAppActionItem(imageVector: ImageVector, description: String, onClick: () -> Unit) {
    IconButton(onClick = { onClick() }) {
        Icon(imageVector = imageVector, contentDescription = description)
    }
}

@Preview
@Composable
fun MainAppBarPreview() {
    MainAppBar()
}