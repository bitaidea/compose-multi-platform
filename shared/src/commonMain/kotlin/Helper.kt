import Repository.CardRepository
import Repository.HomeRepository
import app.cash.sqldelight.db.SqlDriver
import org.koin.core.context.startKoin
import org.koin.dsl.module
import ui.screen.AddCardVM
import ui.screen.DetailScreenModel




fun initKoin(driver:SqlDriver) {
    val homeModule = module {
    factory { driver }
        factory { DetailScreenModel(get()) }
        factory { AddCardVM(get()) }
        single { HomeRepository(get()) }
        single { CardRepository(get()) }
    }
    fun appModule() = listOf(homeModule)
    startKoin {
        modules(appModule())
    }
}


