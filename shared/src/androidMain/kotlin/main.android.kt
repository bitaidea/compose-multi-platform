import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.myapplication.MowjDatabase
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.okhttp.OkHttp
import java.util.concurrent.TimeUnit

actual fun getPlatformName(): String = "Android"
@Composable
actual fun font(name: String, res: String, weight: FontWeight, style: FontStyle): Font {
    val context = LocalContext.current
    val id = context.resources.getIdentifier(res, "font", context.packageName)
    return Font(id, weight, style)
}

actual fun httpClient(config: HttpClientConfig<*>.()-> Unit) = HttpClient(OkHttp){
    config(this)
    engine{
        config{
            retryOnConnectionFailure(true)
            connectTimeout(10, TimeUnit.SECONDS)
        }
    }
}

@Composable fun MainView() = App()

 class DriverFactory(private val context: Context) {
     fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(MowjDatabase.Schema, context, "MowjDatabase.db")
    }
}
