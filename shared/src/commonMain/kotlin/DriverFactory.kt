import app.cash.sqldelight.db.SqlDriver
import com.myapplication.MowjDatabase

expect class DriverFactory {
     fun createDriver(): SqlDriver
}

fun createDatabase(driverFactory:DriverFactory): MowjDatabase {
    val driver = driverFactory.createDriver()
    val database = MowjDatabase(driver)
    // Do more work with the database (see below).
    return database
}