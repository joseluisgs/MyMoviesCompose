// Vamos a hacer una navegacion simple

sealed interface Route {
    object AppEstado : Route
    object AppViewModel : Route
    object AppTodo : Route
}
