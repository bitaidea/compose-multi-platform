@file:OptIn(ExperimentalResourceApi::class)

package screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import org.jetbrains.compose.resources.ExperimentalResourceApi


data class DetailScreen(private val itemId: Int) : Screen {
    @Composable
    override fun Content() {
        val screenModel = getScreenModel<DetailScreenModel>()

        val state by screenModel.state.collectAsState()

        LaunchedEffect(itemId) {

            screenModel.countNumbers()
        }

        val navigator = LocalNavigator.current
        Column {
            when (state) {
                is DetailScreenModel.State.Loading -> Text("loading...")
                is DetailScreenModel.State.Result -> Text("${(state as DetailScreenModel.State.Result).savedId}")
                else -> Text("errr")
            }
            Text("count: ${screenModel.items.collectAsState().value}")

            Button(onClick = {
                screenModel.save()

            }) {
                Text("Save")
            }
            Button(onClick = { navigator?.pop() }) {
                Text("back")
            }
        }

    }
}
