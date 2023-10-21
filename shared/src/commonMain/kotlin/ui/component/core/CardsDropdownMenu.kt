@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)

package ui.component.core

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

//in allCardOption=true , selectedCard=null => all cards
@Composable
fun CardsDropdownMenu(
    modifier: Modifier = Modifier,
    selectedCard: Card?,
    cards: List<Card>,
    allCardOption: Boolean = false,
//    navController: NavController,
    onChanged: ((Card?) -> Unit),
) {
//    val _cards: MutableList<Card> = cards.toMutableList()
//    val _selectedCard: Card
//    if (allCardOption) {
//        _cards.add(0, Card(id = -1, name = "همه حسابها"))
//    }
//    val context = LocalContext.current
//
//    //if !allCardOption cant selectedCard =null
//    if (selectedCard == null) {
//        if (allCardOption)
//            _selectedCard = _cards[0]
//        else {
//            onChanged(_cards.getOrNull(0))
//            return
//        }
//    } else _selectedCard = selectedCard
//    var expanded by remember { mutableStateOf(false) }
//
//    ExposedDropdownMenuBox(
//        expanded = expanded,
//        onExpandedChange = { expanded = !expanded },
//        modifier = modifier
//    ) {
//        WaveTextField(
//            readOnly = true,
//            value = _selectedCard.name,
//            onValueChange = {},
//            trailingIcon = {
//                Row {
//                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
//                    FilledIconButton(onClick = {
//                        navController.navigate(CardtRoutes.AddCard)
//                    }) {
//                        Icon(Icons.Outlined.AddCard, contentDescription = "حساب جدید")
//                    }
//                }
//            },
//            leadingIcon = {
//                CardIcon(_selectedCard, modifier = Modifier)
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .menuAnchor()
//        )
//        ExposedDropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false }
//        ) {
//            _cards.forEach { card ->
//                DropdownMenuItem(
//                    text = {
//                        Text(
//                            card.name,
//                            textAlign = TextAlign.Right,
//                            modifier = Modifier.fillMaxWidth()
//                        )
//                    },
//                    onClick = {
//                        expanded = false
//                        onChanged(if (card.id == -1L) null else card)
//                    },
//                    trailingIcon = {
//                        CardIcon(card, Modifier.size(36.dp))
//                    }
//                )
//            }
//        }
//    }

}


