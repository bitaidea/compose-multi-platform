@file:OptIn(ExperimentalResourceApi::class, ExperimentalResourceApi::class)

package screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import org.jetbrains.compose.resources.ExperimentalResourceApi


class HomeScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current


        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { navigator?.push(DetailScreen(itemId = 123)) }) {
                Text("View details")
            }

        }
    }
}

