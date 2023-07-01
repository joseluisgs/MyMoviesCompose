package dev.joseluis.mymoviescompose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import dev.joseluis.mymoviescompose.navigation.Navigation
import dev.joseluis.mymoviescompose.views.app.MyMoviesApp

// Clase principal de la app --> Actividad
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContent es un composable que permite definir el contenido de la actividad
        setContent {
            // MyMoviesApp es un composable que permite definir la estructura de la app
            MyMoviesApp {
                // Para navegar entre pantallas
                Navigation()
            }
        }
    }


}


// Las funciones con Preview no aceptan parámetros
@Preview(
    showBackground = true,
    widthDp = 400,
    heightDp = 400,
    uiMode = UI_MODE_NIGHT_YES,
    device = Devices.PIXEL_4
)
@Composable
fun DefaultPreview() {
    MyMoviesApp {
        Navigation()
    }
}


/*@Composable
fun StateSample() {
    // O by rememberSaveable salvará el estado de la variable en caso de que la actividad se destruya (rotación de pantalla)
    // o by remember salva el estado, pero si la actividad (o rota la pantalla) se destruye, se pierde el estado
    var text by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(8.dp),
            textAlign = TextAlign.Center
        )
        Button(
            onClick = { text = "" },
            modifier = Modifier.fillMaxWidth(),
            enabled = text.isNotEmpty()
        ) {
            Text(text = "Clear")
        }
    }
}*/


/*@Preview(
    showBackground = true,
    widthDp = 400,
    heightDp = 400,
    uiMode = UI_MODE_NIGHT_YES
)*/

// Puedo usar modifier para modificar el composable
// Crearlo genérico y luego usarlo en varios sitios personalizado
/*
@Composable
fun ButtonText(modifier: Modifier = Modifier) {
    // Cuidado con el orden!!!
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = stringResource(id = R.string.app_name), // Para acceder a los recursos
            color = Color.Red,
            fontSize = 25.sp, // Para las fuentes se usa sp
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Monospace,
            letterSpacing = 2.sp,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center,
            maxLines = 2,
            softWrap = true,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.h4.copy(
                shadow = Shadow(
                    color = Color.Black.copy(alpha = 0.5f),
                    blurRadius = 10f,
                    offset = Offset(10f, 10f)
                )
            ),
            modifier = modifier
                .clickable { */
/*TODO*//*
 }
                .background(Color.Cyan)
                .border(2.dp, Color.Blue)
                .padding(horizontal = 16.dp, vertical = 8.dp)

        )
    }
}
*/
