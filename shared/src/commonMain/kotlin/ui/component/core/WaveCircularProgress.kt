package ui.component.core

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SmallCircularProgress() {
    CircularProgressIndicator(modifier = Modifier.size(12.dp), strokeWidth =  1.dp )
}