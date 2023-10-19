package route

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import screen.DetailsScreen
import screen.MainScreen

interface RootComponent {
    val childStack: Value<ChildStack<*, Child>>
    sealed class Child {
        data class MainChild(val component: MainComponent) : Child()
        data class DetailsChild(val component: DetailsComponent) : Child()
    }
}
@Composable
fun RootContent(rootComponent: RootComponent) {
    Children(rootComponent.childStack) {
        when (val child = it.instance) {
            is RootComponent.Child.MainChild -> MainScreen(child.component)
            is RootComponent.Child.DetailsChild -> DetailsScreen(child.component)
        }
    }
}


interface MainComponent
interface DetailsComponent