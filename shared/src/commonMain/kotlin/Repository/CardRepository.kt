package Repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.db.SqlDriver
import com.myapplication.MowjDatabase
import com.myapplication.Tb_creditcard


class CardRepository(
    sqlDriver: SqlDriver
) {
    val mowjDatabase = MowjDatabase(sqlDriver)
    private val query get() = mowjDatabase.creditCardQueries
    suspend fun addCard(card: Tb_creditcard) {
        query.insertCard(card)
    }

    fun getCard(cardId: Long) = query.getCardById(cardId)
    fun getCardFromBank(bankName: String) = query.getCardFromBank(bankName)
    fun getCardFromCardNumber(cardNumber: String) = query.getCardFromCardNumber(cardNumber)

//    suspend fun updateCard(card: Tb_creditcard) {
//        query.updateCard(card)
//    }

    suspend fun deleteCardAndTrans(cardId: Long) {
//        db.deleteCardTransaction(cardId)
//        db.deleteCardLoan(cardId) //اقساطش هم باد پاک شه
//        db.deleteCardRecives(cardId)
//        db.changeInstallmentToNocalculateAstrans(cardId)
        query.deleteCard(cardId)
    }


    suspend fun deleteCardAndMoveTrans(cardId: Long, slctdMoveId: Long) {
//        db.MoveCardsTrans(cardId, slctdMoveId.toInt())
//        db.MoveCardLoan(cardId, slctdMoveId.toInt())
//        db.MoveInstallmentCards(cardId, slctdMoveId.toInt())
//        db.MoveCardRecives(cardId, slctdMoveId.toInt())
        query.deleteCard(cardId)
    }

    fun getAllCards() = query.getCards().asFlow()

    fun getLastCardId() = query.getLastCardNumber()

    fun getAllTotalFirstSharje() = query.getAllTotalFirstSharje()

//    fun analyzeCard(
//        card: Tb_creditcard,
//        chkCalculatetype: Int
//    ): Flow<Map<String, Long>> {
//        val query = SimpleSQLiteQuery(
//            "select CASE  WHEN t_type like \"transTO:%\"  THEN \"transTO:-\"\n" +
//                    "    ELSE CASE WHEN t_type like \"transFROM:%\"    THEN \"transFROM:+\"\n" +
//                    "    ELSE  t_type END   END  \n" +
//                    "as correctedType,sum(t_price) as price from view_all_trans " +
//                    " where t_card_id =${card.id}" +
//                    checksModeQuery(chkCalculatetype) +
//                    " group by correctedType"
//        )
//        Log.d("analyzeCard", query.sql)
//        return query.analyzeCard(query)
//    }

    fun getCardFromBankAndCardNumber(bankName: String, cardNumber: String): Tb_creditcard =
        query.getCardFromBankAndCardNumber(bankName, cardNumber).executeAsOne()

    fun getCardFromBankAndAccountNumber(bankName: String, accountNumber: String): Tb_creditcard =
        query.getCardFromBankAndAccountNumber(bankName, accountNumber).executeAsOne()

}


