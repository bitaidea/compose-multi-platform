import android.content.Context
import androidx.compose.runtime.Composable
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.myapplication.MowjDatabase

actual fun getPlatformName(): String = "Android"

@Composable fun MainView() = App()

actual class DriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(MowjDatabase.Schema, context, "MowjDatabase.db")
    }
}