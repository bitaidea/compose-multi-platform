@file:OptIn(ExperimentalMaterial3Api::class)

package ui.component.core

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun WaveSearchBar(
    modifier: Modifier = Modifier, value: String,
    searchIcon: @Composable (() -> Unit)? = null,
    onDone: (KeyboardActionScope.() -> Unit)? = null,
    onValueChange: (String) -> Unit = {}
) {
//    val voiceLauncher =
//        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { actResult ->
//            if (actResult.resultCode == Activity.RESULT_OK) {
//                actResult.data?.let {
//                    val result = it.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
//                    onValueChange(result?.get(0).toString())
//                }
//            }
//        }

//    val containerColor = FilledTextFieldTokens.ContainerColor.toColor()
    TextField(
        modifier = modifier
            .scale(0.95f)
            .fillMaxWidth()
            .padding(top = 7.dp, bottom = 4.dp),
        maxLines = 1, singleLine = true,
        shape = RoundedCornerShape(48.dp),
        value = value,
        leadingIcon = searchIcon ?: { Icon(Icons.Rounded.Search, contentDescription = "جستجو") },
        trailingIcon = {
            WaveAnimatedContent(value.isNotEmpty()) { isTrue ->
                if (isTrue)
                    Icon(
                        Icons.Rounded.Close,
                        contentDescription = "حذف متن",
                        Modifier.clickable { onValueChange("") })
//                else
//                    Icon(Icons.Rounded.KeyboardVoice, contentDescription = "ثبت با صدا",Modifier.clickable {
//                        voiceLauncher.launch(voiceIntent())
//                    })
            }
        },
        keyboardActions = KeyboardActions(onSearch = onDone),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
        placeholder = { Text("جستجو...", Modifier.fillMaxWidth(), maxLines = 1) },
        onValueChange = { onValueChange(it) },
        colors = TextFieldDefaults.colors(
//            focusedContainerColor = containerColor,
//            unfocusedContainerColor = containerColor,
//            disabledContainerColor = containerColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),

        )
}


