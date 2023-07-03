package dev.joseluis.mymoviescompose.views.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

// Mis formas personalizadas y tamaños para la app
val Shapes = Shapes(
    small = RoundedCornerShape(4.dp), // Para los botones
    medium = RoundedCornerShape(4.dp), // Para los cards
    //medium = CutCornerShape(8.dp),
    large = RoundedCornerShape(0.dp)
)