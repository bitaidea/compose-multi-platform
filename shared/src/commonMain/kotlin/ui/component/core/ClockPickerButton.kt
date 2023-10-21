package ui.component.core

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreTime
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun ClockPickerButton(
    modifier: Modifier = Modifier,
    title: String,
    date: String?,
    icon: ImageVector = Icons.Rounded.MoreTime,
    enabled: Boolean = true,
    onChangedDate: (String) -> Unit,
) {
//    val mTimePickerDialog = clockDialog(onChangedDate)
    Button(
        onClick = { /*mTimePickerDialog.show() */ },
        shape = RoundedCornerShape(12.dp),
        modifier = modifier.fillMaxWidth().padding(0.dp),
        enabled = enabled
    ) {
        Icon(
            icon,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(
            if (date.isNullOrBlank()) "$title\nتعیین نشده" else
                "$title\n$date",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

//@Composable
//fun clockDialog(onChangedDate: (String) -> Unit): TimePickerDialog {
//    val mContext = LocalContext.current
//    val mCalendar = Calendar.getInstance()
//    val mHour = mCalendar[Calendar.HOUR_OF_DAY]
//    val mMinute = mCalendar[Calendar.MINUTE]
//    return TimePickerDialog(
//        mContext,
//        { _, min: Int, hour: Int ->
//            onChangedDate("${if (min > 9) "$min" else "0$min"}:${if (hour > 9) "$hour" else "0$hour"}")
//        }, mHour, mMinute, true
//    )
//}



