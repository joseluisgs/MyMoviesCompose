import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
@Preview
fun ScreenEstado() {
    // Aquí elegimos material para el resto de la app
    // Vamos a subir el estado del nombre
    var text by remember { mutableStateOf("Hola") }
    PruebasEstado(
        text = text, // Pasamos el estado del nombre
        onClickHola = { text = "Hola Compose!" }, // Pasamos la función para cambiar el nombre
        onSuperLimit = { text = "Te has pasado. Valgo $it" }, // Pasamos la función para cambiar el nombre
        // onGoBack = onGoBack // Pasamos la función para volver a la pantalla anterior
    )

}

@Composable
fun PruebasEstado(text: String, onClickHola: () -> Unit, onSuperLimit: (Int) -> Unit) {
    // Elementos del estado
    // remember es una función que nos permite recordar el estado de un composable
    // mutableStateOf es una función que nos permite crear un estado mutable y observable
    var counter by remember { mutableStateOf(0) }

    // Una columna, vamos a centrarla en la pantalla
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)
    ) {
        Text("Ejemplo con estado local")
        // Un texto
        Text(text)
        // Un botón, le decimos que cuando se pulse se ejecute la función onClickHola
        Button(onClick = onClickHola) {
            Text("Click me!")
        }
        // Otro botón
        Button(onClick = { counter++ }) {
            Text("Click me $counter")
        }
        if (counter > 2) {
            Text("El contador es mayor que 2")
            onSuperLimit(counter) // Llamamos a la función que nos han pasado como parámetro
        }
        // Boton para cambiar la ruta
        /*OutlinedButton(
            onClick = {
                // onGoBack() // Llamamos a la función que nos han pasado como parámetro
            }
        ) {
            Text("Ir a Vista con ViewModel")
        }*/
    }

}