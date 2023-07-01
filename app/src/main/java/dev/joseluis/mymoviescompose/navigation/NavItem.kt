package dev.joseluis.mymoviescompose.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument
import dev.joseluis.mymoviescompose.models.MediaItem

// Clase base principal para definir las rutas de la app
sealed class NavItem(
    internal val baseRoute: String, // Ruta base
    private val navArgs: List<NavArg> = emptyList(), // Lista de parámetros de la ruta
) {
    object Main : NavItem("main") // Ruta principal
    object Detail : NavItem("detail", listOf(NavArg.MediaId)) {
        fun createRoute(mediaItem: MediaItem) = "$baseRoute/${mediaItem.id}"
    }

    val route = run {
        // De esta manera se genera la ruta con los parámetros
        // Ejemplo: detail/{mediaId}/{title}...
        val argValues = navArgs.map { "{${it.key}}" }
        // ahora concatenamos la ruta base con los parámetros con la /
        listOf(baseRoute)
            .plus(argValues)
            .joinToString("/")
    }

    // Se genera la lista de argumentos de la ruta
    val args = navArgs.map {
        navArgument(it.key) { type = it.navType }
    }

}

// Para generar los argumentos de la ruta, +
// key es el nombre del parámetro y navType es el tipo de parámetro (Int, String, etc) por eso *
enum class NavArg(val key: String, val navType: NavType<*>) {
    MediaId("mediaId", NavType.IntType)
}