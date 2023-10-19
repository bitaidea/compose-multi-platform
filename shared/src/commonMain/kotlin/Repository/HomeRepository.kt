package Repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepository {
    fun getAllList(): Flow<Int> {
        return flow<Int> {
            (0..60).forEach {
                emit(it)
                delay(1000)
            }
        }
    }

    suspend fun save():Int{
        delay(1000)
        return 2131234123
    }
}