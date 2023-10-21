

package ui.component.core

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun WaveTonalIconButton(
    modifier: Modifier = Modifier,
    title: String,
    iconStart: ImageVector,
    iconEnd: ImageVector? = null,
    onClick: () -> Unit
) {
    FilledTonalButton(onClick = onClick, modifier) {
        Content(iconStart, title, iconEnd)
    }
}

@Composable
fun WaveIconButton(
    modifier: Modifier = Modifier,
    title: String,
    iconStart: ImageVector,
    iconEnd: ImageVector? = null,
    onClick: () -> Unit
) {
    Button(onClick = onClick, modifier) {
        Content(iconStart, title, iconEnd)
    }
}

//Icons.Rounded.KeyboardArrowLef
@Composable
private fun RowScope.Content(icon: ImageVector, title: String, iconEnd: ImageVector? = null) {
    Icon(icon, contentDescription = title, Modifier.padding(top = 6.dp, bottom = 6.dp))
    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
    Text(title, maxLines = 1, overflow = TextOverflow.Ellipsis,style = MaterialTheme.typography.bodySmall)
    Spacer(Modifier.weight(1f))
    AnimatedContent(targetState = iconEnd, label = "cntAnim") {
        if (it != null)
            Icon(
                it, contentDescription = "بیشتر",
                Modifier.padding(top = 6.dp, bottom = 6.dp)
            )
    }
}
