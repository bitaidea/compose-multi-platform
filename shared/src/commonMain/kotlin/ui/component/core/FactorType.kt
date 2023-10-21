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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Receipt
import androidx.compose.material.icons.rounded.SwapVert
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun FactorType(titleType: MutableState<Boolean>, changeListenser: (value: Boolean) -> Unit) {
    Row(
        Modifier
            .selectableGroup()
            .fillMaxWidth()
            .padding(7.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        val modifier = Modifier.weight(1f)
        WaveRadioButtonVertical(
            modifier = modifier,
            selected = titleType.value,
            title = "عنوان فاکتور",
            icon = Icons.Rounded.List
        ) {
            changeListenser(true)
        }

        WaveRadioButtonVertical(
            modifier = modifier,
            selected = !titleType.value,
            title = "ریز فاکتور",
            icon = Icons.Rounded.Receipt
        ) {
            changeListenser(false)
        }
    }
}

enum class FactorSaleBuyType {
    Buy, Sale
}

@Composable
fun InvoiceSaleBuy(
    value: MutableState<FactorSaleBuyType>,
    changeListenser: (value: FactorSaleBuyType) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(7.dp)
            .fillMaxWidth()
    ) {
        Text(text = "نوع فاکتور:", textAlign = TextAlign.Right)
        Row(
            Modifier
                .selectableGroup(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            val modifier = Modifier.weight(1f)
            WaveRadioButton(
                modifier,
                value.value == FactorSaleBuyType.Sale,
                "فاکتور فروش"
            ) {
                changeListenser(FactorSaleBuyType.Sale)
            }

            WaveRadioButton(
                modifier,
                value.value == FactorSaleBuyType.Buy,
                "فاکتور خرید"
            ) {
                changeListenser(FactorSaleBuyType.Buy)
            }
        }
    }
}

enum class FactorAndKalaType {
    All, Buy, Sell
}

@Composable
fun InvoiceTypeSelector(
    value: MutableState<FactorAndKalaType>,
    isContainInOutPrd: Boolean,
    changeListenser: (value: FactorAndKalaType) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(7.dp)
            .fillMaxWidth()
    ) {
        Text(text = "نوع:", textAlign = TextAlign.Right)
        Row(
            Modifier
                .selectableGroup(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val modifier = Modifier.weight(1f)
            WaveRadioButtonVertical(
                modifier = modifier,
                selected = value.value == FactorAndKalaType.All,
                title = if (isContainInOutPrd) "همه\n" else "همه",
                icon = Icons.Rounded.SwapVert
            ) {
                changeListenser(FactorAndKalaType.All)
            }
            WaveRadioButtonVertical(
                modifier = modifier,
                selected = value.value == FactorAndKalaType.Buy,
                title = if (isContainInOutPrd) "فاکتور خرید \nو ورود کالا" else "فاکتور خرید",
                icon = Icons.Rounded.KeyboardArrowDown
            ) {
                changeListenser(FactorAndKalaType.Buy)
            }

            WaveRadioButtonVertical(
                modifier = modifier,
                selected = value.value == FactorAndKalaType.Sell,
                title = if (isContainInOutPrd) "فاکتور فروش \nو خروج کالا" else "فاکتور فروش",
                icon = Icons.Rounded.KeyboardArrowUp
            ) {
                changeListenser(FactorAndKalaType.Sell)
            }
        }
    }
}


@Composable
fun InvoiceStatus(
    value: MutableList<Int>
) {
    Column(
        modifier = Modifier
            .padding(7.dp)
            .fillMaxWidth()
    ) {
        Text(text = "وضعیت فاکتورها:", textAlign = TextAlign.Right)
        Row(
            Modifier.selectableGroup(),
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
            WaveRtlCheckbox(
                modifier = modifier,
                checked = value.contains(Invoice.BEDEHKAR),
                title = "بدهکار"
            ) {
                if (it)
                    value.add(Invoice.BEDEHKAR)
                else
                    value.remove(Invoice.BEDEHKAR)
            }

            WaveRtlCheckbox(
                modifier = modifier,
                checked = value.contains(Invoice.BESTANKAR),
                title = "بستانکار"
            ) {
                if (it)
                    value.add(Invoice.BESTANKAR)
                else
                    value.remove(Invoice.BESTANKAR)
            }

            WaveRtlCheckbox(
                modifier = modifier,
                checked = value.contains(Invoice.TASVIYESHODE),
                title = "تسویه شده"
            ) {
                if (it)
                    value.add(Invoice.TASVIYESHODE)
                else
                    value.remove(Invoice.TASVIYESHODE)
            }
        }
    }
}

class Invoice {
    companion object {
        val TASVIYESHODE = 53434
        val BESTANKAR = 3123123
        val BEDEHKAR = 983274
    }
}