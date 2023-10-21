package Repository

import app.cash.sqldelight.db.SqlDriver
import com.myapplication.MowjDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class HomeRepository(
//    private  val mowjDatabase: MowjDatabase
    sqlDriver: SqlDriver
) {
    val mowjDatabase = MowjDatabase(sqlDriver)
    private val query get() = mowjDatabase.playerQueries
    suspend fun selectAll() = withContext(Dispatchers.IO) {
        query.selectAll().executeAsList()
    }

    fun getAllList(): Flow<Int> {
        return flow<Int> {
            (0..60).forEach {
                emit(it)
                delay(1000)
            }
        }
    }

    fun save(id:Long,name:String){
        query.insert(id,name)
    }
}