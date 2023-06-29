package dev.joseluis.mymoviescompose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                   MediaItem()
                }
            }
        }
    }
}

// Las funciones con Preview no aceptan parámetros
@Preview(
    showBackground = true,
    widthDp = 400,
    heightDp = 400,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun DefaultPreview() {
    MyMoviesComposeTheme {
        MediaItem()
    }
}

@Composable
fun MediaItem() {
    // Una columna
    Column {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .background(Color.Red)
        ) {
            // Aquí irán las dos images
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
               .fillMaxWidth()
               .background(MaterialTheme.colors.secondary)
                .padding(16.dp)
        ) {
            Text(text = "Title 1")
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 400,
    heightDp = 400,
    uiMode = UI_MODE_NIGHT_YES
)

// Puedo usar modifier para modificar el composable
// Crearlo genérico y luego usarlo en varios sitios personalizado
@Composable
fun ButtonText(modifier: Modifier = Modifier) {
    // Cuidado con el orden!!!
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Text(text = "Button",
            modifier = modifier
                .clickable { /*TODO*/ }
                .background(Color.Cyan)
                .border(2.dp, Color.Blue)
                .padding(horizontal = 16.dp, vertical = 8.dp)

        )
    }
}
