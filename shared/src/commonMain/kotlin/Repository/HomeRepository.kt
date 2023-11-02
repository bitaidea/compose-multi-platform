package Repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.db.SqlDriver
import com.myapplication.MowjDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class HomeRepository(
//    private  val mowjDatabase: MowjDatabase
    sqlDriver: SqlDriver
) {
    val mowjDatabase = MowjDatabase(sqlDriver)
    private val query get() = mowjDatabase.playerQueries
    suspend fun selectAll() = withContext(Dispatchers.IO) {
        query.selectAll().asFlow()
    }

    fun save(id:Long,name:String){
        query.insert(id,name)
    }
}