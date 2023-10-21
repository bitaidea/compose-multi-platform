package ui.component.core

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.EditCalendar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun DatePickerButton(
    title: String,
    date: String?,
    enabled: Boolean = true,
    modifier: Modifier = Modifier.fillMaxWidth(),
    icon: ImageVector = Icons.Rounded.EditCalendar,
    onChangedDate: (String) -> Unit,
) {
    val openDialog = remember { mutableStateOf(false) }
    Button(
        onClick = { openDialog.value = true },
        shape = RoundedCornerShape(12.dp), modifier = modifier.padding(0.dp), enabled = enabled
    ) {
        Icon(
            icon,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(
            if (date.isNullOrBlank()) "$title\nتعیین نشده" else
                "$title\n1404/02/34",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }

    DatePicker(openDialog, onChangedDate)
}

@Composable
private fun DatePicker(
    openDialog: MutableState<Boolean>,
    onChangedDate: (String) -> Unit
) {

}


@Composable
fun DatePickerAny(
    modifier: Modifier = Modifier,
    onChangedDate: (String) -> Unit,
    content: @Composable () -> Unit
) {

    val openDialog = remember { mutableStateOf(false) }
    Box(
        modifier.clickable { openDialog.value = true }) {
        content()
    }
    DatePicker(openDialog, onChangedDate)
}


