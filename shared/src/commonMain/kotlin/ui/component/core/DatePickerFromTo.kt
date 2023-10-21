package ui.component.core

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

enum class DefaultDate {
    Today,
    Month,
    Year,
    Infinite;

    val level: Int
        get() = ordinal + 1
}

@Composable
fun DatePickerFromTo(
    fromDate: String?,
    toDate: String?,
    onFromDateChange: (String?) -> Unit,
    onToDateChange: (String?) -> Unit,
    defaultDates: DefaultDate = DefaultDate.Month
) {
//    LaunchedEffect(key1 = Unit){
//        if (fromDate.isNullOrEmpty() || toDate.isNullOrEmpty()){
//            when(defaultDates.level){
//                DefaultDate.Today.level ->{
//                    onFromDateChange(calendarToString())
//                    onToDateChange(calendarToString())
//                }
//                DefaultDate.Month.level->{
//                    onFromDateChange(Extra.getFromToThisMonth()[0])
//                    onToDateChange(Extra.getFromToThisMonth()[1])
//                }
//                DefaultDate.Year.level->{
//                    onFromDateChange(Extra.getFromToThisYear()[0])
//                    onToDateChange(Extra.getFromToThisYear()[1])
//                }
//                DefaultDate.Infinite.level->{
//                    onFromDateChange(null)
//                    onToDateChange(null)
//                }
//            }
//        }
//    }

    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(
            onClick = { onFromDateChange("1404/12/32");onToDateChange("1404/12/34") },
            Modifier.weight(0.3f)
        ) {
            Text(text = "امروز")
        }
        Button(onClick = {}, Modifier.weight(0.3f)) {
            Text(text = "این ماه")
        }
        Button(onClick = {}, Modifier.weight(0.3f)) {
            Text(text = "امسال")
        }
    }
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        DatePickerButton(
            "تاریخ شروع",
            fromDate ?: "",
            modifier = Modifier.weight(1f),
            onChangedDate = onFromDateChange
        )
        Spacer(modifier = Modifier.height(8.dp))
        DatePickerButton(
            "تاریخ پایان",
            toDate ?: "",
            modifier = Modifier.weight(1f),
            onChangedDate = onToDateChange
        )
    }
}