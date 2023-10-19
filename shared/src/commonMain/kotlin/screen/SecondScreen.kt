@file:OptIn(ExperimentalResourceApi::class)

package screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import getPlatformName
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import route.DetailsComponent
import route.RootComponent

@Composable
fun DetailsScreen(component: DetailsComponent) {
    Text("Second Screen")
}