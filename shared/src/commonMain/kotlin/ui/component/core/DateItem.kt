package ir.esfandune.wave.compose.component.event

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun DateItem(date: String?) {
    if (date == null) return
    Text(
        textAlign = TextAlign.End,
        text = getTitle(date),
        fontWeight = FontWeight.W400,
        modifier = Modifier.padding(horizontal = 12.dp),

        )
}

@Composable
private fun getTitle(tdate: String): String {

    return tdate
}
