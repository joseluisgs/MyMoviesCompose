package dev.joseluis.mymoviescompose.views.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.joseluis.mymoviescompose.views.theme.MyMoviesComposeTheme

// Estrucutra básica de un composable
@Composable
fun MyMoviesApp(content: @Composable () -> Unit) {
    // MyMoviesComposeTheme es un composable que permite definir los colores, tipografía y formas de la app
    MyMoviesComposeTheme {
        // Una superficie es un composable que permite definir el color de fondo de la app
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
            content()
        }
    }
}
