@file:OptIn(ExperimentalResourceApi::class, ExperimentalResourceApi::class)

package screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import org.jetbrains.compose.resources.ExperimentalResourceApi
import ui.component.core.WaveCard


class HomeScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

WaveCard {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { navigator?.push(DetailScreen(itemId = 123)) }) {
            Text("View details")
        }


    }
}

    }
}

