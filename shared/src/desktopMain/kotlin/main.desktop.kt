import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.myapplication.MowjDatabase
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.okhttp.OkHttp
import java.util.Locale
import java.util.ResourceBundle
import java.util.concurrent.TimeUnit


actual fun getPlatformName(): String = "desktop"

@Composable
fun UIShow() = App()

 class DriverFactory {
     fun createDriver(): SqlDriver {
        val driver: SqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        MowjDatabase.Schema.create(driver)
        return driver
    }
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


@Composable
actual fun font(name: String, res: String, weight: FontWeight, style: FontStyle): Font =
  Font("font/$res.ttf", weight, style)


actual object Strings {
    actual fun get(id: String): String {
        val locale = Locale("en") // Set the appropriate locale (e.g., based on user preferences)
        val bundle = ResourceBundle.getBundle("string", locale)
        return  bundle.getString(id)
    }
}