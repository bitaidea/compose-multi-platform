@file:OptIn(ExperimentalResourceApi::class, ExperimentalResourceApi::class)

package ui.screen

import Strings
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
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
import org.jetbrains.compose.resources.painterResource
import ui.component.core.WaveCard


class HomeScreen : Screen {
    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        WaveCard {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = { navigator?.push(DetailScreen(itemId = 123)) }) {
                    Text("vm db di flow")
                }
                Button(onClick = { navigator?.push(AddCardPage(123)) }) {
                    Text(Strings.get("err"))
                }

                    Image(
                        painterResource("compose-multiplatform.xml"),
                        null
                    )

            }
        }

    }
}

