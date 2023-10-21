package ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun mowjBG() = Brush.linearGradient(
    colors = listOf(
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.secondary,
    ),
)


@Composable
fun mowjBG2() = Brush.verticalGradient(
    colors = listOf(
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.secondary,
    ),
)


@Composable
fun hGradiant(color: Color = Color.Transparent, color2: Color = Color.Transparent) =
    Brush.horizontalGradient(
        colors = listOf(
            color,
            color2,
        ),
    )

@Composable
fun vGradiant(color: Color = Color.Transparent, color2: Color = Color.Transparent) =
    Brush.verticalGradient(
        colors = listOf(
            color,
            color2,
        ),
    )
