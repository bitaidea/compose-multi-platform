@file:OptIn(ExperimentalMaterial3Api::class)

package ui.component.core

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CreditCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun CardIcon(
    slctdCard: Card?,
    modifier: Modifier = Modifier,
    tint: Color = MaterialTheme.colorScheme.onSurface
) =
    CardIcon(slctdCard?.bankName, modifier, tint)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardIcon(
    bankName: String?,
    modifier: Modifier = Modifier,
    tint: Color = MaterialTheme.colorScheme.onSurface
) {
    Icon(
        Icons.Rounded.CreditCard,
        contentDescription = "بانک",
        modifier.size(InputChipDefaults.AvatarSize), tint
    )
}

class Card {
    var id :Int=-1;
    val bankName: String = "عباسبانک"
}