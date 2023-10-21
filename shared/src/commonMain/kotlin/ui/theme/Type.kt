package ir.esfandune.wave.compose.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp


val Kalameh = FontFamily(
//    Font(R.font.kalame_fanum),
//    Font(R.font.kalame_fanum_medium, FontWeight.W400),
//    Font(R.font.kalame_fanum_semibold, FontWeight.W600),
//    Font(R.font.kalame_fanum_semibold, FontWeight.W500),
//    Font(R.font.kalame_fanum_bold, FontWeight.W800)
)


// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = Typography().titleLarge.copy(fontFamily = Kalameh, fontSize = 17.sp),
    titleMedium = Typography().titleMedium.copy(fontFamily = Kalameh),
    titleSmall = Typography().titleSmall.copy(fontFamily = Kalameh),

    bodyLarge = Typography().bodyMedium.copy(fontFamily = Kalameh),
    bodyMedium = Typography().bodyMedium.copy(fontFamily = Kalameh),
    bodySmall = Typography().bodySmall.copy(fontFamily = Kalameh),
//no used more:
    labelLarge = Typography().labelLarge.copy(fontFamily = Kalameh),
    labelMedium = Typography().labelMedium.copy(fontFamily = Kalameh),
    labelSmall = Typography().labelSmall.copy(fontFamily = Kalameh),

    displayLarge = Typography().displayLarge.copy(fontFamily = Kalameh),
    displayMedium = Typography().displayMedium.copy(fontFamily = Kalameh),
    displaySmall = Typography().displaySmall.copy(fontFamily = Kalameh),

    headlineLarge = Typography().headlineLarge.copy(fontFamily = Kalameh),
    headlineMedium = Typography().headlineMedium.copy(fontFamily = Kalameh),
    headlineSmall = Typography().headlineSmall.copy(fontFamily = Kalameh),

    )