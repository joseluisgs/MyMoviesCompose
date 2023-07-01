package dev.joseluis.mymoviescompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.joseluis.mymoviescompose.views.detail.DetailScreen
import dev.joseluis.mymoviescompose.views.main.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    // Se definen las pantallas y sus rutas
    NavHost(
        navController = navController,
        startDestination = NavItem.Main.route
    ) {
        // Cada pantalla es un composable
        composable("main") {
            // MainScreen es un composable que permite definir el contenido de la actividad
            MainScreen { mediaItem ->
                // Navegamos a la pantalla de detalle
                navController.navigate(
                    // Se genera la ruta con los parámetros
                    NavItem.Detail.createRoute(mediaItem.id)
                )
            }

        }
        // Fijamos los parámetros de la ruta
        composable(
            route = NavItem.Detail.route,
            // Para pasar parámetros entre pantallas
            arguments = NavItem.Detail.args

        ) {
            // DetailScreen es un composable que permite definir el contenido de la actividad
            // it.arguments?.getInt("movieId") --> Recuperamos el parámetro de la ruta
            DetailScreen(
                movieId = requireNotNull(it.arguments?.getInt(NavArg.MediaId.key)) { "movieId is null" },
                onUpClick = { navController.popBackStack() }
            )
        }
    }
}
