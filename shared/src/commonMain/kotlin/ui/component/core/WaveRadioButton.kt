package ui.component.core

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun WaveRadioButtonVertical(
    modifier: Modifier = Modifier,
    selected: Boolean,
    title: String,
    icon: ImageVector,
    enabled: Boolean = true,
    isDanger: Boolean = false,
    onClick: () -> Unit = {}
) {

    val colors =
        if (!isDanger) CardDefaults.outlinedCardColors()
        else CardDefaults.outlinedCardColors(containerColor = MaterialTheme.colorScheme.errorContainer)

    val selectedColors =
        if (!isDanger) CardDefaults.cardColors()
        else CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.errorContainer)

    val color = if (!isDanger) MaterialTheme.colorScheme.onSurfaceVariant
    else MaterialTheme.colorScheme.onErrorContainer

    Card(
        modifier = if (enabled) modifier.clickable { onClick() } else modifier.alpha(0.4f),
        elevation = if (selected) CardDefaults.cardElevation() else CardDefaults.outlinedCardElevation(),
        colors = if (selected) selectedColors else colors,
    ) {
        Box(Modifier.padding(7.dp)) {
            RadioButton(
                selected = selected,
                onClick = null,
                enabled = enabled,
                colors = RadioButtonDefaults.colors(
                    selectedColor = color
                )
            )
            Column(Modifier.padding(top = 18.dp)) {
                Icon(
                    icon, contentDescription = title,
                    Modifier
                        .fillMaxWidth()
                        .height(36.dp)
                )
                Text(text = title, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            }
        }

    }
}

@Composable
fun WaveRadioButtonHorizontal(
    modifier: Modifier = Modifier,
    selected: Boolean,
    title: String,
    icon: ImageVector,
    enabled: Boolean = true,
    /*positive = true , false, nul==> neutral (خنثی)*/
    isDanger: Boolean = false,
    onClick: () -> Unit = {}
) {

    val colors =
        if (!isDanger) CardDefaults.outlinedCardColors()
        else CardDefaults.outlinedCardColors(containerColor = MaterialTheme.colorScheme.errorContainer)

    val selectedColors =
        if (!isDanger) CardDefaults.cardColors()
        else CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.errorContainer)

    val color = if (!isDanger) MaterialTheme.colorScheme.onSurfaceVariant
    else MaterialTheme.colorScheme.onErrorContainer



    Card(
        modifier = if (enabled) modifier.clickable { onClick() } else modifier.alpha(0.4f),
        elevation = if (selected) CardDefaults.cardElevation() else CardDefaults.outlinedCardElevation(),
        colors = if (selected) selectedColors else colors,
    ) {
        Row(
            Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            RadioButton(
                selected = selected,
                onClick = null,
                enabled = enabled,
                colors = RadioButtonDefaults.colors(
                    selectedColor = color
                )
            )
            Icon(icon, contentDescription = title, Modifier.size(30.dp))
            Text(text = title, textAlign = TextAlign.Center/*, modifier = Modifier.weight(0.2f)*/)
        }
    }
}


@Composable
fun WaveRadioButton(
    modifier: Modifier = Modifier,
    selected: Boolean,
    title: String,
    changeDir: Boolean = false,
    isDanger: Boolean = false,
    onClick: () -> Unit = {}
) {

    val colors =
        if (!isDanger) CardDefaults.outlinedCardColors()
        else CardDefaults.outlinedCardColors(containerColor = MaterialTheme.colorScheme.errorContainer)

    val selectedColors =
        if (!isDanger) CardDefaults.cardColors()
        else CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.errorContainer)

    val color = if (!isDanger) MaterialTheme.colorScheme.onSurfaceVariant
    else MaterialTheme.colorScheme.onErrorContainer

    Card(
        modifier.clickable { onClick() },
//        border = if (selected) null else CardDefaults.outlinedCardBorder(),
        elevation = if (selected) CardDefaults.cardElevation() else CardDefaults.outlinedCardElevation(),
        colors = if (selected) selectedColors else colors,
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (changeDir) {
                Text(text = title, textAlign = TextAlign.End, modifier = Modifier.weight(1f))
                RadioButton(selected = selected, onClick = onClick,  colors = RadioButtonDefaults.colors(
                    selectedColor = color
                ))
            } else {
                RadioButton(selected = selected, onClick = onClick,  colors = RadioButtonDefaults.colors(
                    selectedColor = color
                ))
                Text(text = title, textAlign = TextAlign.Start, modifier = Modifier.weight(1f))
            }

        }

    }
}