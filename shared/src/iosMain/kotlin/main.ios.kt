import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.window.ComposeUIViewController
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.myapplication.MowjDatabase
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.darwin.Darwin
import kotlinx.coroutines.runBlocking
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.resource
import platform.Foundation.NSBundle
import platform.Foundation.NSURL

actual fun getPlatformName(): String = "iOS"
fun MainViewController() = ComposeUIViewController { App() }
actual object Strings {
    actual fun get(id: String): String = id.localized()
}
fun String.localized(): String {
    val localizedString = NSBundle.mainBundle.localizedStringForKey(this, this, null)
    if (localizedString != this) return localizedString

    val baseResourcePath = NSBundle.mainBundle.pathForResource("en", "lproj")
        ?.let { NSURL(fileURLWithPath = it) }
    val baseBundle = baseResourcePath?.let { NSBundle(it) }

    if (baseBundle != null) {
        val baseString = baseBundle.localizedStringForKey(this, this, null)
        if (baseString != this) return baseString
    }

    return this
}

actual fun httpClient(config: HttpClientConfig<*>.()-> Unit)= HttpClient(Darwin){
    config(this)
    engine{
        configureRequest{
            setAllowsCellularAccess(true)
        }
    }
}

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