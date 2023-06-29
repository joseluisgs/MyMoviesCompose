package dev.joseluis.mymoviescompose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import dev.joseluis.mymoviescompose.ui.theme.MyMoviesComposeTheme

// Clase principal de la app --> Actividad
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContent es un composable que permite definir el contenido de la actividad
        setContent {
            // MyMoviesComposeTheme es un composable que permite definir los colores, tipografía y formas de la app
            MyMoviesComposeTheme {
                // Una superficie es un composable que permite definir el color de fondo de la app
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                   MyMainScreen()
                }
            }
        }
    }
}

// Las funciones con Preview no aceptan parámetros
@Preview(
    showBackground = true,
    widthDp = 400,
    heightDp = 200,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun DefaultPreview() {
    MyMoviesComposeTheme {
        MyMainScreen()
    }
}

@Composable
fun MyMainScreen() {
    // Row es un composable que permite definir una fila de elementos
    Row(modifier = Modifier
        .fillMaxSize()
        .background(Color.LightGray),
        verticalAlignment = Alignment.CenterVertically, // verticalAlignment es un parámetro que permite definir la alineación vertical de los elementos
        horizontalArrangement = Arrangement.SpaceEvenly // HorizontalArrangement es un parámetro que permite definir la distribución de los elementos
    ) {
        Greeting(name = "Pepe", modifier = Modifier.background(Color.Blue))
        Greeting(name = "Compose",
            modifier = Modifier.background(Color.Red).weight(1f)
        )
        Greeting(name = "Jose",
            modifier = Modifier.background(Color.Green).weight(2f)
        )
    }


}

// Greting es un composable que permite definir un texto
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}

