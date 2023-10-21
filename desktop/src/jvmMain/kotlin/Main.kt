
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import androidx.compose.material.*
import UIShow
import DriverFactory
import initKoin
fun main() {
    application {
        val windowState = rememberWindowState()
        initKoin(DriverFactory().createDriver())
        Window(
            onCloseRequest = ::exitApplication,
            state = windowState,
            title = "My Project"
        ) {
            UIShow()
        }
    }
}


