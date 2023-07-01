package dev.joseluis.mymoviescompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
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
        composable(NavItem.Main) {
            MainScreen(onMediaClick = {
                navController.navigate(NavItem.Detail.createRoute(it))
            })
        }
        // Fijamos los parámetros de la ruta
        composable(NavItem.Detail) { backStackEntry ->
            DetailScreen(
                movieId = backStackEntry.findArg(NavArg.MediaId),
                onUpClick = { navController.popBackStack() }
            )
        }
    }
}


// funciones de extensión para simplificar la definición de las pantallas
private fun NavGraphBuilder.composable(
    navItem: NavItem, // Ruta
    content: @Composable (NavBackStackEntry) -> Unit, // Composable de la pantalla
) {
    composable(
        route = navItem.route,
        arguments = navItem.args
    ) {
        content(it) // Se ejecuta el composable de la pantalla
    }
}

// funciones de extensión para simplificar la definición de las pantallas
// Es una función de extensión de NavBackStackEntry
// refied T es para que el compilador sepa el tipo de dato que se va a retornar
private inline fun <reified T> NavBackStackEntry.findArg(arg: NavArg): T {
    val value = arguments?.get(arg.key)
    requireNotNull(value) { "Argument ${arg.key} is missing or has a null value" }
    return value as T
}
