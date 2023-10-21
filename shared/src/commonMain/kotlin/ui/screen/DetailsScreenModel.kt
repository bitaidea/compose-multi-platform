package ui.screen

import Repository.HomeRepository
import androidx.compose.runtime.mutableStateOf
import app.cash.sqldelight.coroutines.mapToList
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.myapplication.HockeyPlayer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailScreenModel(
    private val repository: HomeRepository
) : StateScreenModel<DetailScreenModel.State>(State.Init) {

    sealed class State {
        object Init : State()
        object Loading : State()
        data class Result(val savedId: Int) : State()
    }

    private val _items = MutableStateFlow<List<HockeyPlayer>?>(emptyList())
    val items = _items.asStateFlow()

    fun countNumbers() {
        coroutineScope.launch {
            repository.selectAll().mapToList(Dispatchers.IO).collect{
                _items.value =it
            }

        }
    }

    val id= mutableStateOf(0L)
    val name = mutableStateOf("")

    fun save() {
        coroutineScope.launch {
            repository.save(id.value,name.value)
        }
    }


}