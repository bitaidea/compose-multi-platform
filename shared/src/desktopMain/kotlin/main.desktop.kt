import androidx.compose.runtime.Composable
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.myapplication.MowjDatabase


actual fun getPlatformName(): String = "desktop"

@Composable
fun UIShow() = App()

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        val driver: SqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        MowjDatabase.Schema.create(driver)
        return driver
    }
}