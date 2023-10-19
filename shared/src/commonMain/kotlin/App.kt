import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.jetbrains.compose.resources.ExperimentalResourceApi
import route.RootComponent
import route.RootContent

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {

    val lifecycle = LifecycleRegistry()
    val root = DefaultRootComponent(componentContext = DefaultComponentContext(lifecycle))


    val ro2ot = RootComponent(DefaultComponentContext(lifecycle))

    MaterialTheme {
        RootContent(root)
    }
}


expect fun getPlatformName(): String