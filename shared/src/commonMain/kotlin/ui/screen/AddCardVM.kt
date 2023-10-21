package ui.screen

import Repository.HomeRepository
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.mutableStateOf
import app.cash.sqldelight.coroutines.mapToList
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.myapplication.HockeyPlayer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AddCardVM(
//    private val repository: HomeRepository
) : ScreenModel{

//    val editCard = mutableStateOf<Card?>(null)

    val name = mutableStateOf("")
    val cardNumber = mutableStateOf("")
    val bankName = mutableStateOf("دیگر")
    val accountNumber = mutableStateOf<String?>(null)
    val firstCharge = mutableStateOf("0")
    val haveDasteChk = mutableStateOf(true)
    val shaba = mutableStateOf<String?>(null)

    val snackbarHostState = SnackbarHostState()
    val showSnack: (String) -> Unit =
        {
            coroutineScope.launch(Dispatchers.IO) {
                snackbarHostState.showSnackbar(it)
            }
        }
    val showHelpDialog = mutableStateOf(false)

    fun setNote(id: Long) {
        coroutineScope.launch(Dispatchers.IO) {
//            editCard.value = cardRepository.getCard(id)
            fillForm()
        }
    }

    private fun fillForm() {
//        editCard.value?.let {
//            name.value = it.name
//            cardNumber.value = it.card_number
//            bankName.value = it.bankName
//            accountNumber.value = it.accountnumber
//            firstCharge.value = it.firstCharge ?: "0"
//            haveDasteChk.value = it.haveDasteChk == 1
//            shaba.value = it.shaba
//        }
    }

    fun onSave(onCompleted: () -> Unit) {
        if (name.value.isBlank()) {
            showSnack("وارد کردن نام برای حساب الزامیست.")
            return
        } else if (!shaba.value.isNullOrBlank() && (shaba.value?.length ?: 0) < 24) {
            showSnack("شماره شبا باید ۲۴ رقم یا خالی باشد.")
            return
        } else {
//            viewModelScope.launch(Dispatchers.IO) {
//                val card = Card(
//                    id = editCard.value?.id ?: (cardRepository.getLastCardId() + 1),
//                    name = name.value,
//                    card_number = cardNumber.value,
//                    bankName = bankName.value,
//                    accountnumber = accountNumber.value,
//                    firstCharge = firstCharge.value,
//                    haveDasteChk = if (haveDasteChk.value) 1 else 0,
//                    shaba = shaba.value
//                )
//                if (editCard.value == null)
//                    cardRepository.addCard(card)
//                else cardRepository.updateCard(card)
//            }
            onCompleted()
        }

    }
}