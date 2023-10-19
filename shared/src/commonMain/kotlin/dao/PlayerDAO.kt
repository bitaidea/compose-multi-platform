package dao

import com.myapplication.MowjDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class PlayerDAO (
    private val mowjDatabase: MowjDatabase
) {

    private val  query get() = mowjDatabase.playerQueries
    suspend fun selectAllByPage(page: Long) = withContext(Dispatchers.IO) {
        query.selectAll().executeAsList()
    }

}