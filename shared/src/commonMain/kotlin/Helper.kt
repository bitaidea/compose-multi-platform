import Repository.HomeRepository
import org.koin.core.context.startKoin
import org.koin.dsl.module
import screen.DetailScreenModel


val homeModule = module {
    factory { DetailScreenModel(get()) }
    single { HomeRepository() }
}

fun initKoin(){
    fun appModule() = listOf(homeModule)

    startKoin {
        modules(appModule())
    }
}