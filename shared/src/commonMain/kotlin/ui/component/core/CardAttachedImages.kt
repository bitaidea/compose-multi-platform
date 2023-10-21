package ui.component.core

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CardAttachedImages(folderPath: String, modifier: Modifier = Modifier) {

    WaveCard(modifier) {
        Text("پیوست اسناد:", Modifier.padding(12.dp))
        Row(
            Modifier.padding(12.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

        }
    }
}