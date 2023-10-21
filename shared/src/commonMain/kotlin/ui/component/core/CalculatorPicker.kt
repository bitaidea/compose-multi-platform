package ui.component.core

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Calculate
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection

@Composable
fun CalculatorIcon(
//    navController: NavController,
    defValue: String? = null,
    roundResult: Boolean = true,
    onResult: (String) -> Unit = {}
) {
    val fDefValue = if (defValue.isNullOrBlank()) null else defValue
    FilledIconButton(onClick = {
//        if (roundResult)
//            navController.navigate("${OtherRoutes.CalculatorRoundRslt}/$fDefValue")
//        else
//            navController.navigate("${OtherRoutes.Calculator}/$fDefValue")
//
//        navController.addOnDestinationChangedListener { controller, destination, arguments ->
//            val secondScreenResult = controller.currentBackStackEntry
//                ?.savedStateHandle?.getStateFlow<String?>("result", null)
//            secondScreenResult?.value?.let {
//                onResult(it)
//            }
//        }
    }) {
        Icon(Icons.Outlined.Calculate, contentDescription = "ماشین حساب")
    }


}


///only call from CalculatorIcon
@Composable
fun CalculatorSheet(
//    navController: NavHostController,
    defValue: Double? = null,
    roundResult: Boolean = true
) {
    val finalResult = rememberSaveable { mutableStateOf("") }
    BottomCardForNavController(fabButtons = {
        FloatingActionButton(onClick = {
//            navController.previousBackStackEntry?.savedStateHandle?.set(
//                "result",
//                finalResult.value
//            )
//            navController.popBackStack()
        }) {
            Icon(
                imageVector = Icons.Rounded.Done,
                contentDescription = "ذخیره"
            )
        }
    }, onClose = { /*navController.popBackStack()*/ }) {
        Column(
            Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                val focusManager = LocalFocusManager.current
                focusManager.clearFocus()
//                Calculator(defValue = defValue, roundResult = roundResult) { result ->
//                    finalResult.value = result
//                }
            }
        }
    }
}