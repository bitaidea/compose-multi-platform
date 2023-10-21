import Repository.HomeRepository
import app.cash.sqldelight.db.SqlDriver
import org.koin.core.context.startKoin
import org.koin.dsl.module
import screen.DetailScreenModel




fun initKoin(sqlDriver: SqlDriver) {
    val homeModule = module {
    factory { sqlDriver }
        factory { DetailScreenModel(get()) }
        single { HomeRepository(get()) }
    }
    fun appModule() = listOf(homeModule)
    startKoin {
        modules(appModule())
    }
}


