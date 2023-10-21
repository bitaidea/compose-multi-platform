@file:OptIn(ExperimentalResourceApi::class)

package ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import org.jetbrains.compose.resources.ExperimentalResourceApi


data class DetailScreen(private val itemId: Int) : Screen {
    @Composable
    override fun Content() {
        val screenModel = getScreenModel<DetailScreenModel>()

        val playerList = screenModel.items.collectAsState().value

        LaunchedEffect(itemId) {

            screenModel.countNumbers()
        }

        val navigator = LocalNavigator.current
        Column {
//            when (state) {
//                is DetailScreenModel.State.Loading -> Text("loading...")
//                is DetailScreenModel.State.Result -> Text("${(state as DetailScreenModel.State.Result).savedId}")
//                else -> Text("errr")
//            }
            playerList?.forEach {
                Row {
                    Text(text =it.player_number.toString())
                    Text(text =it.full_name)
                }
            }

            Row {
               TextField(
                   value = screenModel.id.value.toString(),
                   onValueChange = {
                       screenModel.id.value =it.toLong()
                   },
                   placeholder = { Text(text = "id") },
                   keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
               )
                Spacer(modifier = Modifier.width(10.dp))
                TextField(
                    value = screenModel.name.value,
                    onValueChange = {
                        screenModel.name.value =it
                    },
                    placeholder = { Text(text = "name") }
                )
            }

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
