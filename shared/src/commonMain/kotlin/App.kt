import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.jetbrains.compose.resources.ExperimentalResourceApi
import screen.HomeScreen
import screen.MainScreen

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {

    MaterialTheme {
//        MainScreen()
        Navigator(HomeScreen())
    }
}


expect fun getPlatformName(): String