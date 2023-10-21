@file:OptIn(ExperimentalMaterial3Api::class)

package ui.component.core

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddPhotoAlternate
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun CircleImagePicker(
    _showImagePath: String? = null,
    folderParh: String,
    tmpName: String? = null,
    onImageChanged: (tmpImgAdrs: String?) -> Unit = {}
) {

    FilledIconButton(
        onClick = {

        },
//        modifier = modifier
    ) {
        Icon(Icons.Outlined.AddPhotoAlternate, contentDescription = "افزودن تصویر")
    }
}


///System.currentTimeMillis()+".jpg"