import android.content.Context
import androidx.compose.runtime.Composable
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.myapplication.MowjDatabase

actual fun getPlatformName(): String = "Android"

@Composable fun MainView() = App()

 class DriverFactory(private val context: Context) {
     fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(MowjDatabase.Schema, context, "MowjDatabase.db")
    }
}
