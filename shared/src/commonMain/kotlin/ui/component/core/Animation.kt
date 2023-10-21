package ui.component.core

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier


@Composable
fun WaveAnimatedContent(
    trueState: Boolean,
    modifier: Modifier = Modifier,
    clip: Boolean = false,
    states: @Composable (Boolean) -> Unit
) {
    AnimatedContent(modifier = modifier, targetState = trueState, transitionSpec = {
        if (targetState) {
            (slideInVertically { height -> height } + fadeIn()).togetherWith(slideOutVertically { height -> -height } + fadeOut())
        } else {
            (slideInVertically { height -> -height } + fadeIn()).togetherWith(slideOutVertically { height -> height } + fadeOut())
        }.using(
            SizeTransform(clip = clip)
        )
    }, label = "slideFade"
    ) { states(it) }
}






@Composable
fun WaveScaleAnimatedContent(
    trueState: Boolean,
    modifier: Modifier = Modifier,
    states: @Composable (Boolean) -> Unit
) {
    AnimatedContent(modifier = modifier, targetState = trueState, transitionSpec = {
            scaleIn().togetherWith(scaleOut())
    }, label = "scale"
    ) { states(it) }
}

@Composable
fun WaveAnimatedContent(
    targetState: Int,
    modifier: Modifier = Modifier,
    clip: Boolean = false,
    states: @Composable (Int) -> Unit
) {
    WaveAnimatedContent(targetState.toLong(), modifier, clip) { states(it.toInt()) }
}

@Composable
fun WaveAnimatedContent(
    targetState: Long,
    modifier: Modifier = Modifier,
    clip: Boolean = false,
    states: @Composable (Long) -> Unit
) {
    AnimatedContent(modifier = modifier,
        targetState = targetState,
        transitionSpec = {
            // Compare the incoming number with the previous number.
            if (targetState > initialState) {
                (slideInVertically { height -> height } + fadeIn()).togetherWith(slideOutVertically { height -> -height } + fadeOut())
            } else {
                (slideInVertically { height -> -height } + fadeIn()).togetherWith(slideOutVertically { height -> height } + fadeOut())
            }.using(
                SizeTransform(clip = clip)
            )
        }, label = "fadeSlide"
    ) { states(it) }
}

@Composable
fun WaveAnimatedContentScale(
    trueState: Boolean,
    modifier: Modifier = Modifier,
    clip: Boolean = true,
    states: @Composable (Boolean) -> Unit
) {
    AnimatedContent(modifier = modifier, targetState = trueState, transitionSpec = {
        if (targetState) {
            (scaleIn() + fadeIn()).togetherWith(scaleOut() + fadeOut())
        } else {
            (scaleIn() + fadeIn()).togetherWith(scaleOut() + fadeOut())
        }.using(
            SizeTransform(clip = clip)
        )
    }, label = "scaleFade"
    ) { states(it) }
}




@Composable
fun rotateAnimation(isRotated: Boolean,rotateDegree:Float=180f, onFinished: () -> Unit = {}): Float {
    val angle: Float by animateFloatAsState(
        targetValue = if (isRotated) rotateDegree else 0F,
        animationSpec = tween(),
        finishedListener = { onFinished() }, label = "rotate"
    )
    return angle
}

@Composable
 fun rotateInfinite(duration:Int = 3000): Animatable<Float, AnimationVector1D> {
    var currentRotation by remember { mutableFloatStateOf(0f) }
    val rotation = remember { Animatable(currentRotation) }
    LaunchedEffect(Unit) {
        rotation.animateTo(
            targetValue = currentRotation + 360f,
            animationSpec = infiniteRepeatable(
                animation = tween(duration, easing = LinearEasing),
            )
        ) {
            currentRotation = value
        }
    }
    return rotation
}