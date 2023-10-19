@file:OptIn(ExperimentalResourceApi::class)

package screen

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import org.jetbrains.compose.resources.ExperimentalResourceApi



class HomeScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        Button(onClick = { navigator?.push(DetailScreen(itemId = 123)) }) {
            Text("View details")
        }
    }
}

data class DetailScreen(private val itemId: Int) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        Text("Second Screen")
        Button(onClick = { navigator?.pop() }) {
            Text("back")
        }
    }
}

//@Composable
//fun DetailsScreen() {
//    Text("Second Screen")
//}