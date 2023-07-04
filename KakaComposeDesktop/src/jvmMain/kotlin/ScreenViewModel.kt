import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


class ViewModel {
    // Defino el estado para la app
    var state by mutableStateOf(State())
        private set

    data class State(
        val text: String = "Hola",
        val counter: Int = 0
    )

    // Defino las acciones que pueden cambiar el estado
    fun changeText(newText: String) {
        state = state.copy(text = newText)
    }

    fun incrementCounter() {
        state = state.copy(counter = state.counter + 1)
    }

    fun reset() {
        state = state.copy(text = "", counter = 0)
    }
}


@Composable
@Preview
fun ScreenViewModel(vm: ViewModel) {
    PruebasViewModel(
        text = vm.state.text, // Pasamos el estado del nombre
        counter = vm.state.counter, // Pasamos el estado del contador
        onClickHola = { vm.changeText("Hola ¿Qué tal?") }, // Pasamos la función para cambiar el nombre
        onSuperLimit = { vm.changeText("Te has pasado del límite que es $it. Vales ${vm.state.counter}") },// Pasamos la función para cambiar el nombre
        onIncrement = { vm.incrementCounter() }, // Pasamos la función para incrementar el contador
        onReset = { vm.reset() } // Pasamos la función para resetear el estado
        //onGoBack = onGoBack // Pasamos la función para volver a la pantalla anterior
    )
}

@Composable
fun PruebasViewModel(
    text: String,
    counter: Int,
    onClickHola: () -> Unit,
    onSuperLimit: (Int) -> Unit,
    onIncrement: () -> Unit,
    onReset: () -> Unit,
    //onGoBack: () -> Unit
) {

    // Una columna, vamos a centrarla en la pantalla
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)
    ) {
        Text("Ejemplo con ViewModel")
        // Un texto
        Text(text)
        // Un botón, le decimos que cuando se pulse se ejecute la función onClickHola
        Button(onClick = onClickHola) {
            Text("Click me!")
        }
        // Otro botón
        Button(
            onClick = onIncrement,
            colors = ButtonDefaults.buttonColors(backgroundColor = if (counter >= 2) MaterialTheme.colors.secondary else MaterialTheme.colors.primary)
        ) {
            Text("Click me $counter")
        }
        if (counter >= 2) {
            Text("El contador es mayor que 2")
            onSuperLimit(2) // Llamamos a la función que nos han pasado como parámetro
        }
        Button(onClick = onReset) {
            Text("Reset")
        }
        // Boton para cambiar la ruta
        /* Button(onClick = { *//*onGoBack()*//* }) {
            Text("Ir a Vista con Estado")
        }*/
    }

}