@file:OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)

package ui.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Help
import androidx.compose.material.icons.rounded.Save
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import ui.component.core.CardIcon
import ui.component.core.SimpleTopBar
import ui.component.core.WaveCard
import ui.component.core.WavePriceTextField
import ui.component.core.WaveTextField

private const val MinCardNameLentgh = 8

@OptIn(ExperimentalMaterial3Api::class)
data class AddCardPage(private val editCardId: Long? = null) : Screen {
    @Composable
    override fun Content() {
        val pageVM = getScreenModel<AddCardVM>()
        val navController = LocalNavigator.current
        editCardId?.let {
            val inited = rememberSaveable { mutableStateOf(false) }
            LaunchedEffect(key1 = Unit) {
                if (!inited.value) {
                    inited.value = true
//                pageVM.setNote(it)
                }
            }
        }


//    val resources = LocalContext.current.resources
        val progress = remember { mutableStateOf(0.0f) }
        progress.value = chkProgress()
        val animatedProgress by animateFloatAsState(
            targetValue = progress.value,
            animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
        )
        LaunchedEffect(key1 = Unit){
            pageVM.ktorTest()
        }
        Scaffold(
            topBar = {
                Column {
                    SimpleTopBar(title = /*if (pageVM.editCard.value == null) "حساب جدید" else*/ "ویرایش حساب") {
                        navController?.pop()
                    }
                    LinearProgressIndicator(
                        modifier = Modifier
                            .semantics(mergeDescendants = true) {}
                            .fillMaxWidth(),
//                color = MaterialTheme.colorScheme.secondaryContainer,
                        progress = animatedProgress,
                    )
                }
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        pageVM.onSave { navController?.pop() }
                    },
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Save,
                        contentDescription = "ذخیره"
                    )
                }
            },
            content = {

                Content(it)
            },
            snackbarHost = { SnackbarHost(pageVM.snackbarHostState) },
        )

//    if (pageVM.showHelpDialog.value)
//        HelpDialog(text = resources.getString(R.string.hlp_dastechk)) {
//            pageVM.showHelpDialog.value = false
//        }

    }

    @Composable
    private fun Content(
        paddingValues: PaddingValues,
//    navController: NavController,
        pageVM: AddCardVM = getScreenModel()
    ) {

        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
                .padding(bottom = 45.dp)
        ) {
            Text("Code:${pageVM.codeStatue.value}")
            CardPreview()
            WaveCard(Modifier.padding(12.dp)) {
                Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {

                    WaveTextField(
                        pageVM.name.value,
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                        placeholder = "مثلا کارت هزینه های شرکت",
                        label = { Text("نام دلخواه: *") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        onValueChange = { pageVM.name.value = it })
                    WaveTextField(
                        pageVM.cardNumber.value,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        placeholder = "شماره کارت",
                        label = { Text("شماره کارت:") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        onValueChange = {
                            pageVM.cardNumber.value = it
                            pageVM.bankName.value =
                                "بانک خشوگ"// Extra.getBankNameFromCardNumber(it)
                        })

//                BanksDropdownMenu(
//                    bankName = pageVM.bankName.value,
//                    onChanged = { pageVM.bankName.value = it })
                    WaveTextField(
                        pageVM.accountNumber.value ?: "",
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        placeholder = "شماره حساب",
                        label = { Text("شماره حساب:") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        onValueChange = { pageVM.accountNumber.value = it })
                }
            }

            WaveCard(Modifier.padding(12.dp)) {
                Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = pageVM.haveDasteChk.value,
                            onCheckedChange = { pageVM.haveDasteChk.value = it })
                        Text(text = "دسته چک دارد؟", Modifier.weight(1f))
                        IconButton(onClick = { pageVM.showHelpDialog.value = true }) {
                            Icon(Icons.Rounded.Help, contentDescription = "راهنما")
                        }
                    }

                    WavePriceTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = pageVM.firstCharge.value,
                        onValueChange = { pageVM.firstCharge.value = it },
                        placeholder = "موجودی اولیه",
                        label = { Text("موجودی اولیه:") },
                    )
                    WaveTextField(
                        pageVM.shaba.value ?: "",
                        placeholder = "بدون IR",
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        label = { Text("شماره شبا:") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        onValueChange = { pageVM.shaba.value = it.take(24) })

                    Text(
                        text = "* شماره شبا الزامی نیست اما در صورت ورود برای اطمینان از صحت شماره وارد شده بررسی می شود طول اعداد ۲۴ رقم باشد.",
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

        }
    }

    @Composable
    private fun CardPreview(pageVM: AddCardVM = getScreenModel()) {
        Box(
            Modifier
                .background(
                    MaterialTheme.colorScheme.primary,
                    RoundedCornerShape(
                        topEnd = 0.dp,
                        topStart = 0.dp,
                        bottomEnd = 20.dp,
                        bottomStart = 20.dp
                    )
                )
        ) {
            Column(Modifier.padding(25.dp)) {

                Text(
                    text = pageVM.name.value.ifBlank { "نام کارت" },
                    fontWeight = FontWeight.W600,
                    color = MaterialTheme.colorScheme.onPrimary, maxLines = 1
                )
                Text(
//                text = cardNumberFormatter(pageVM.cardNumber.value, true),
                    text = pageVM.cardNumber.value,
                    color = MaterialTheme.colorScheme.onPrimary, maxLines = 1
                )
                Spacer(modifier = Modifier.height(25.dp))
                Row {
                    Text(
                        text = (pageVM.accountNumber.value ?: "").ifBlank { "••••••••••••••••" },
                        color = MaterialTheme.colorScheme.onPrimary, maxLines = 1
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    AnimatedContent(pageVM.bankName.value) {
                        CardIcon(
                            bankName = "بانک ملی",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            }
        }
    }

    @Composable
    private fun chkProgress(pageVM: AddCardVM = getScreenModel()): Float {

        var progress = 0
        progress += if (pageVM.cardNumber.value.trim().length > MinCardNameLentgh) 30 else 0
        progress += if (pageVM.name.value.isNotBlank()) 30 else 0
        progress += if (pageVM.firstCharge.value.isNotBlank()) 15 else 0
        progress += if (pageVM.cardNumber.value.isNotBlank()) 15 else 0
        progress += if (!pageVM.shaba.value.isNullOrBlank()) 10 else 0
        return progress / 100f
    }
}