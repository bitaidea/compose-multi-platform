import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import cafe.adriel.voyager.navigator.Navigator
import ir.esfandune.wave.compose.theme.WaveAndroidTheme
import ui.screen.HomeScreen

@Composable
fun App() {
    WaveAndroidTheme {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Navigator(HomeScreen())
        }
    }
}


expect fun getPlatformName(): String


@Composable
expect fun font(
    name: String,
    res: String,
    weight: FontWeight,
    style: FontStyle
): Font

expect object Strings {

    fun get(id: String): String
}
