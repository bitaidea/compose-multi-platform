package screen

import Repository.HomeRepository
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.myapplication.HockeyPlayer
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

    private val _items = MutableStateFlow<HockeyPlayer?>(null)
    val items = _items.asStateFlow()

    fun countNumbers() {
        coroutineScope.launch {
            _items.value =   repository.selectAll().firstOrNull()
//            repository.getAllList()
//                .collect {
//                    _items.value = it
//                }
        }
    }

    fun save() {
        coroutineScope.launch {
            mutableState.value = State.Loading
            mutableState.value = State.Result(repository.save())
        }
    }


}

data class Post(var id: Int, var name: String)