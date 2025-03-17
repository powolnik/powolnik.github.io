package com.powolnik.portfolio.animations

import androidx.compose.animation.core.*
import androidx.compose.foundation.clickable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.math.PI
import kotlin.math.cos

@Composable
fun FadeInAnimation(
    visible: Boolean,
    durationMs: Int = 500,
    content: @Composable () -> Unit
) {
    var animationProgress by remember { mutableStateOf(0f) }
    val animatedAlpha = animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(durationMs, easing = LinearEasing)
    )

    LaunchedEffect(visible) {
        animationProgress = if (visible) 1f else 0f
    }

    content.invoke().Modifier.alpha(animatedAlpha.value)
}

@Composable
fun RotateAnimation(
    modifier: Modifier = Modifier,
    angleDegrees: Float = 360f,
    durationMs: Int = 700
) {
    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = angleDegrees,
        animationSpec = infiniteRepeatable(
            tween(durationMs, easing = LinearEasing),
            RepeatMode.Restart
        )
    )

    modifier.rotate(angle)
}

@Composable
fun PulseAnimation(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    pulseColor: Color = Color.Blue.copy(alpha = 0.3f)
) {
    var isPulsing by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (isPulsing) 1.15f else 1f,
        animationSpec = spring(dampingRatio = 0.8f, stiffness = 100f)
    )

    Box(modifier = modifier
        .clickable { onClick() }
        .scale(scale)) {
        // Content to pulse goes here
    }

    LaunchedEffect(isPulsing) {
        if (isPulsing) {
            delay(300)
            isPulsing = false
        }
    }
}
