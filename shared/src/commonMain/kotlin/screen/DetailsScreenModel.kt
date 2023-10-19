package screen

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DetailScreenModel(
//    private val repository: PostRepository
) : StateScreenModel<DetailScreenModel.State>(State.Init) {

    sealed class State {
        object Init : State()
        object Loading : State()
        data class Result(val post: Post) : State()
    }

    fun getPost(id: Int) {
        coroutineScope.launch {
            mutableState.value = State.Loading
            delay(2000)
            mutableState.value = State.Result(post = Post(id,"salam"))
        }
    }
}

data class Post (var id: Int,var name:String)