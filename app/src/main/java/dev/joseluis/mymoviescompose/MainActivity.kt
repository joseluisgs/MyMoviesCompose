package dev.joseluis.mymoviescompose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import dev.joseluis.mymoviescompose.models.MediaItem
import dev.joseluis.mymoviescompose.models.MediaItem.*
import dev.joseluis.mymoviescompose.models.getMediaItems
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
                   StateSample()
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
    uiMode = UI_MODE_NIGHT_YES,
    device = Devices.PIXEL_4
)
@Composable
fun DefaultPreview() {
    MyMoviesComposeTheme {
        StateSample()
    }
}

@Composable
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
}

@Composable
fun MediaList() {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp), // Variables  // GridCells.Fixed(2), // Celdas fijas
        contentPadding = PaddingValues(2.dp),
    ) {
        items(getMediaItems()) { item ->
            MediaListItem(item = item, modifier = Modifier.padding(2.dp))
        }
    }
}


@Composable
fun MediaListItem(item: MediaItem, modifier: Modifier = Modifier) {
    // Una columna
    Column(modifier = modifier){
        Box(modifier = Modifier
            .height(200.dp)
        ) {
            // Aquí irán las dos images
            // Imagen con Coil
            AsyncImage(model = item.thumb, contentDescription = "Image 1",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
            if (item.type == Type.VIDEO) {
                // Iconos desde Material Design
                Icon(
                    imageVector = Icons.Default.PlayCircleOutline,
                    contentDescription = "Play",
                    tint = Color.White.copy(alpha = 0.6f),
                    modifier = Modifier
                        .size(120.dp)
                        //.clip(RoundedCornerShape(92.dp))
                        //.background(Color.Black.copy(alpha = 0.5f))
                        .align(Alignment.Center)
                )
            }
            // Iconos desde recursos
            /*Icon(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "Play", tint = Color.White,
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(92.dp))
                    .background(Color.Black.copy(alpha = 0.5f))
                    .align(Alignment.Center)
            )*/
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.secondary)
                .padding(16.dp)
        ) {
            Text(text = item.title,
                fontSize = MaterialTheme.typography.h6.fontSize,
                fontWeight = MaterialTheme.typography.h6.fontWeight,
            )
        }
    }
}

/*@Preview(
    showBackground = true,
    widthDp = 400,
    heightDp = 400,
    uiMode = UI_MODE_NIGHT_YES
)*/

// Puedo usar modifier para modificar el composable
// Crearlo genérico y luego usarlo en varios sitios personalizado
@Composable
fun ButtonText(modifier: Modifier = Modifier) {
    // Cuidado con el orden!!!
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center) {
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
                .clickable { /*TODO*/ }
                .background(Color.Cyan)
                .border(2.dp, Color.Blue)
                .padding(horizontal = 16.dp, vertical = 8.dp)

        )
    }
}
