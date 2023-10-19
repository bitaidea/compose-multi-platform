import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.compose.withDI
import screen.DetailScreenModel
import screen.HomeScreen

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {


    val di = DI {
        DI.Module(name = "detail") {
            bindProvider { DetailScreenModel() }
        }
    }

    MaterialTheme {
        withDI(di) {
            Navigator(HomeScreen())
        }

    }
}


expect fun getPlatformName(): String