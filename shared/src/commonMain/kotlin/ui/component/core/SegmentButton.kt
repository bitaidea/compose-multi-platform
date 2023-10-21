package ui.component.core

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun SegmentButton(
    modifier: Modifier = Modifier,
    values: List<String>,
    selectedIndex: Int,
    rounded: Dp = 25.dp,
    onSelected: (Int) -> Unit
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy((-1).dp)
    ) {
        values.forEachIndexed { index, item ->
            Row(
                modifier = Modifier
                    .weight(1f)
                    .background(
                        color = if (selectedIndex == index) MaterialTheme.colorScheme.secondaryContainer else Color.Transparent,
                        shape = when (index) {
                            0 -> firstShape(rounded)
                            values.size - 1 -> lastShape(
                                rounded
                            )
                            else -> middleShape()
                        }
                    )
                    .border(
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurfaceVariant),
                        shape = when (index) {
                            0 -> firstShape(rounded)
                            values.size - 1 -> lastShape(
                                rounded
                            )
                            else -> middleShape()
                        }
                    )
                    .clip(shape = when (index) {
                        0 -> firstShape(rounded)
                        values.size - 1 -> lastShape(
                            rounded
                        )
                        else -> middleShape()
                    })
                    .clickable { onSelected(index) }, horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    item,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(7.dp),
                    maxLines = 1,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

    }
}

@Composable
private fun firstShape(rounded: Dp) =
    RoundedCornerShape(bottomStart = rounded, topStart = rounded)

@Composable
private fun middleShape() =
    RoundedCornerShape(0.dp)

@Composable
private fun lastShape(rounded: Dp) =
    RoundedCornerShape(bottomEnd = rounded, topEnd = rounded)
