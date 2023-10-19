@file:OptIn(ExperimentalResourceApi::class)

package screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import org.jetbrains.compose.resources.ExperimentalResourceApi


data class DetailScreen(private val itemId: Int) : Screen {
    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel<DetailScreenModel> { DetailScreenModel() }
        val state by screenModel.state.collectAsState()

        LaunchedEffect(itemId){
            screenModel.getPost(itemId)
        }

        val navigator = LocalNavigator.current
        Column {
            when (state) {
                is DetailScreenModel.State.Loading -> Text("loading...")
                is DetailScreenModel.State.Result -> Text((state as DetailScreenModel.State.Result).post.name)
                else -> Text("errr")
            }
            Text("Second Screen")
            Button(onClick = { navigator?.pop() }) {
                Text("back")
            }
        }

    }
}
