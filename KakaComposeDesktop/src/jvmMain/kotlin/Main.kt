import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.CollectionsBookmark
import androidx.compose.material.icons.filled.Task
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import theme.MyTheme


// Función principal de la aplicación
// Application entry point
fun main() = application {
    // Windows es el composable para lanzar la ventana de la aplicación
    // Lo primero es almacenar la ruta actual, y lo cargamos en el HomeView
    var route by remember { mutableStateOf<Route>(Route.AppTodo) }
    Window(
        title = "Compose for Desktop",
        onCloseRequest = ::exitApplication
    ) {
        MyTheme {
            // Usamos Scaffold para tener un layout básico con un AppBar
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Jugando con Compose") },
                        navigationIcon = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Default.Android, contentDescription = null)
                            }
                        }
                    )
                },
                bottomBar = {
                    BottomNavigation(
                        backgroundColor = MaterialTheme.colors.primary,
                        contentColor = MaterialTheme.colors.onPrimary
                    ) {
                        BottomNavigationItem(
                            icon = { Icon(Icons.Default.CollectionsBookmark, contentDescription = null) },
                            label = { Text("Estado") },
                            selected = route == Route.AppEstado,
                            onClick = { route = Route.AppEstado }
                        )
                        BottomNavigationItem(
                            icon = { Icon(Icons.Default.Bookmark, contentDescription = null) },
                            label = { Text("ViewModel") },
                            selected = route == Route.AppViewModel,
                            onClick = { route = Route.AppViewModel }
                        )
                        BottomNavigationItem(
                            icon = { Icon(Icons.Default.Task, contentDescription = null) },
                            label = { Text("Todo") },
                            selected = route == Route.AppTodo,
                            onClick = { route = Route.AppTodo }
                        )
                    }
                }

            ) {
                // Llamamos a la función App con rutas
                RouteApp(route = route)
            }
        }
    }
}

@Composable
private fun RouteApp(route: Route) {
    var localRoute by remember { mutableStateOf(route) }

    // Llamamos a la función que nos devuelve el composable que corresponda
    // Como cambiam "reactivamente" la ruta, se volverá a llamar a esta función
    // y renderizará el composable que corresponda
    when (route) {
        Route.AppEstado -> ScreenEstado()
        Route.AppViewModel -> ScreenViewModel(vm = ViewModel())
        Route.AppTodo -> ScreenTodo(vm = TodoViewModel())
    }
}

