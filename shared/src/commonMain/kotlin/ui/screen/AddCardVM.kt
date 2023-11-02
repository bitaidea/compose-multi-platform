package ui.screen

import ClientApis
import Repository.CardRepository
import Repository.HomeRepository
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.myapplication.Tb_creditcard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch

class AddCardVM(
    private val cardRepository: CardRepository
) : ScreenModel {

    val editCard = mutableStateOf<Tb_creditcard?>(null)

    val name = mutableStateOf("")
    val cardNumber = mutableStateOf("")
    val bankName = mutableStateOf("دیگر")
    val accountNumber = mutableStateOf<String?>(null)
    val firstCharge = mutableStateOf("0")
    val haveDasteChk = mutableStateOf(true)
    val shaba = mutableStateOf<String?>(null)
    val codeStatue = mutableStateOf(0)

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
            coroutineScope.launch(Dispatchers.IO) {

                val card = Tb_creditcard(
//                    id = editCard.value?.id ,
                    id = 1 ,
                    name = name.value,
                    card_number = cardNumber.value,
                    bankName = bankName.value,
                    accountnumber = accountNumber.value,
                    frstSharj = firstCharge.value,
                    haveDasteChk = if (haveDasteChk.value) 1 else 0,
                    shaba = shaba.value,
                    cardOrder = 0,
                    cvv2 = -1,
                    expire_date = null,
                    pass =null
                )
                if (editCard.value == null)
                    cardRepository.addCard(card)
//                else cardRepository.updateCard(card)
            }
            onCompleted()
        }

    }

    fun ktorTest(){
        coroutineScope.launch(Dispatchers.IO){
            codeStatue.value =ClientApis().getTest().status.value

        }
    }
}