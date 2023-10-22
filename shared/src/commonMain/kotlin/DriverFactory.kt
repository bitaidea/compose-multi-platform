import app.cash.sqldelight.db.SqlDriver
import com.myapplication.MowjDatabase
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig


expect fun  httpClient(config: HttpClientConfig<*>.()-> Unit={}): HttpClient
fun createDatabase(driver:SqlDriver): MowjDatabase {
//    val driver = driverFactory.createDriver()
    val database = MowjDatabase(driver)
    // Do more work with the database (see below).
    return database
}
