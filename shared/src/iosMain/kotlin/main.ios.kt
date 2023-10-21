import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.window.ComposeUIViewController
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.myapplication.MowjDatabase
import kotlinx.coroutines.runBlocking
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.resource

actual fun getPlatformName(): String = "iOS"

fun MainViewController() = ComposeUIViewController { App() }


// in src/nativeMain/kotlin
//actual class DriverFactory {
//    actual fun createDriver(): SqlDriver {
//        return NativeSqliteDriver(MowjDatabase.Schema, "MowjDatabase.db")
//    }
//}

fun createDriver(): SqlDriver {
    return NativeSqliteDriver(MowjDatabase.Schema, "MowjDatabase.db")
}

private val cache: MutableMap<String, Font> = mutableMapOf()
@OptIn(ExperimentalResourceApi::class)
@Composable
actual fun font(name: String, res: String, weight: FontWeight, style: FontStyle): Font {
    return cache.getOrPut(res) {
        val byteArray = runBlocking {
            resource("font/$res.ttf").readBytes()
        }
        androidx.compose.ui.text.platform.Font(res, byteArray, weight, style)
    }
}