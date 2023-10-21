package ui.component.core

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun WaveSwitch(
    checked: Boolean,
    modifier: Modifier = Modifier,
    onCheckedChange: ((Boolean) -> Unit)? = null
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier,
        thumbContent = if (checked) {
            {
                Icon(
                    imageVector = Icons.Rounded.Check,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )
            }
        } else null,
        colors = SwitchDefaults.colors(
            checkedTrackColor = MaterialTheme.colorScheme.surfaceVariant,
            checkedThumbColor = MaterialTheme.colorScheme.secondary,
            checkedIconColor = MaterialTheme.colorScheme.onSecondary
        )
    )
}