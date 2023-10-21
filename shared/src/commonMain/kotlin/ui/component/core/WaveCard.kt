package ui.component.core

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WaveCard(
    modifier: Modifier = Modifier,
    border: BorderStroke? = null,
    elevation: CardElevation = CardDefaults.cardElevation(),
    content: @Composable ColumnScope.() -> Unit,
    ) {
    Card(
        modifier = modifier,
        border = border,
        elevation = elevation,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(
                alpha = 0.4f
            )
        ),
        content = content
    )
}
