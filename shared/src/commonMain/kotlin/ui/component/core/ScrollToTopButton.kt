package ui.component.core

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
 fun ScrollToTopButton(
    modifier: Modifier = Modifier,
    showFabUp: Boolean,
    listState: LazyListState
) {
    val coroutineScope = rememberCoroutineScope()
    WaveAnimatedContent(
        showFabUp, modifier = modifier.padding(12.dp)
    ) {
        if (it)
            FloatingActionButton(
                onClick = { coroutineScope.launch { listState.animateScrollToItem(0) } }) {
                Icon(
                    Icons.Rounded.KeyboardArrowUp,
                    contentDescription = "پیمایش به ابتدای لیست"
                )
            }
    }
}