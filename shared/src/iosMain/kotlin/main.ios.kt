import androidx.compose.ui.window.ComposeUIViewController
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.myapplication.MowjDatabase

actual fun getPlatformName(): String = "iOS"

fun MainViewController() = ComposeUIViewController { App() }

fun createDriver(): SqlDriver {
    return NativeSqliteDriver(MowjDatabase.Schema, "MowjDatabase.db")
}