package dev.joseluis.mymoviescompose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
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
                   MediaList()
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
        MediaList()
    }
}

@Composable
fun MediaList() {
    LazyRow(
        contentPadding = PaddingValues(4.dp), // Padding entre el contenido y el borde
        horizontalArrangement = Arrangement.spacedBy(4.dp), // Espacio entre los items
    ) {
        items(getMediaItems()) { item ->
            MediaListItem(item)
        }
    }
}


@Composable
fun MediaListItem(item: MediaItem) {
    // Una columna
    Column(
        modifier = Modifier.width(200.dp)

    ) {
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
