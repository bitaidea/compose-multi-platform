package ui.component.core

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

enum class BedBesType {
    BEDEHKAR, BESTANKAR, ALL
}

@Composable
fun BedBesType(
    selectedValue: MutableState<BedBesType>
) {
    Column(
        modifier = Modifier
            .padding(7.dp)
            .fillMaxWidth()
    ) {
        Text(text = "نوع گزارش:", textAlign = TextAlign.Right)
        Row(
            Modifier
                .selectableGroup()
                .padding(top = 7.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            val modifier = Modifier
                .weight(1f)
                .padding(7.dp)
                .height(48.dp)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    shape = RoundedCornerShape(7.dp)
                )
            WaveRadioButton(
                modifier = modifier,
                selected = selectedValue.component1() == BedBesType.BEDEHKAR,
                title = "بدهکار"
            ) {
                selectedValue.value = BedBesType.BEDEHKAR
            }

            WaveRadioButton(
                modifier = modifier,
                selected = selectedValue.component1() == BedBesType.BESTANKAR,
                title = "بستانکار"
            ) {
                selectedValue.value = BedBesType.BESTANKAR
            }

            WaveRadioButton(
                modifier = modifier,
                selected = selectedValue.component1() == BedBesType.ALL,
                title = "هر دو"
            ) {
                selectedValue.value = BedBesType.ALL
            }
        }
    }
}