import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

data class Todo(
    val id: Int,
    val text: String,
    val done: Boolean = false
)

class TodoViewModel {
    // Defino el estado para la app
    var state by mutableStateOf(State())
        private set

    private var nextId = 2

    data class State(
        val todos: List<Todo> = listOf(Todo(1, "Todo 1", false), Todo(2, "Todo 2", true)),
    )

    // Defino las acciones que pueden cambiar el estado
    fun addTodo(textTodo: String) {
        state = state.copy(
            todos = state.todos + Todo(
                id = ++nextId,
                text = textTodo
            )
        )
        println("Todo añadido ${state.todos}")
    }

    fun delete(idTodo: Int) {
        state = state.copy(
            todos = state.todos.filter { it.id != idTodo }
        )
        println("Todo eliminado ${state.todos}")
    }

    fun toggleDone(idTodo: Int) {
        state = state.copy(
            todos = state.todos.map {
                if (it.id == idTodo) {
                    it.copy(done = !it.done)
                } else {
                    it
                }
            }
        )
        println("Todo actualizado ${state.todos}")
    }
}

@Composable
fun ScreenTodo(vm: TodoViewModel) {
    // Lo primero es hacer una columna
    Column(
        // Con fillMaxSize ocupamos todo el espacio disponible
        modifier = Modifier.fillMaxSize(),
        // Con Arrangement.Center centramos el contenido
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TituloTodo()
        // Otra fila con un texto
        InputTodo(
            onAddTodo = { vm.addTodo(it) }
        )
        // Separador
        Divider(color = MaterialTheme.colors.primary, thickness = 1.dp, modifier = Modifier.padding(16.dp))
        TodoList(vm.state.todos, onRemoveTodo = { vm.delete(it) }, onToggleDone = { vm.toggleDone(it) })

    }
}

@Composable
fun TodoList(todos: List<Todo>, onRemoveTodo: (Int) -> Unit, onToggleDone: (Int) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (todos.isEmpty()) {
            Text(
                text = "No hay tareas",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp),
            )
            {
                item { Text("Lista de Tareas: ${todos.count()}") }
                items(items = todos, key = { it.id }) { todo ->
                    TodoItem(todo = todo, onRemoveTodo = onRemoveTodo, onToggleDone = onToggleDone)
                }
                item { Text("Terminadas: ${todos.count { it.done }}") }
            }
        }
    }
}

@Composable
@Preview
fun TodoItem(todo: Todo, onRemoveTodo: (Int) -> Unit, onToggleDone: (Int) -> Unit) {
    // Hacemos una fila con un texto
    // Fila con vectores
    Card(
        elevation = 4.dp,
        modifier = Modifier.size(300.dp, 50.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween, // Espacio entre elementos
            modifier = Modifier.padding(8.dp)
        ) {
            // Título
            // Si está hecho, tachamos el texto
            Text(
                todo.text,
                fontSize = MaterialTheme.typography.h6.fontSize,
                textDecoration = if (todo.done) TextDecoration.LineThrough else TextDecoration.None,
                color = if (todo.done) MaterialTheme.colors.onSurface.copy(alpha = 0.5f) else MaterialTheme.colors.onSurface,
            )
            Row {
                // Checkbox
                Checkbox(
                    checked = todo.done,
                    onCheckedChange = { onToggleDone(todo.id) }
                )
                // Boton
                Button(
                    onClick = { onRemoveTodo.invoke(todo.id) },
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.error)
                ) {
                    Icon(Icons.Default.Delete, contentDescription = null)
                }
            }
        }
    }
}

@Composable
fun InputTodo(onAddTodo: (String) -> Unit) {
    var text by remember { mutableStateOf("") }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Cuadro de texto
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Tarea") }
        )
        // Botón
        Button(onClick = {
            if (text.isNotEmpty()) {
                onAddTodo.invoke(text.trim())
                text = ""
            }
        }) {
            Icon(Icons.Default.Add, contentDescription = null)
        }
    }
}

@Composable
private fun TituloTodo() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "TodoApp",
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.primary
        )
    }
}
