package com.mohitmandalia.photogallery.core.util

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 *   Created by Mohit Mandalia
 */

fun Modifier.defaultPadding() : Modifier =
    padding(8.dp)

fun Modifier.defaultScreenPadding() : Modifier =
    padding(16.dp)

fun Modifier.horizontalPadding(size: Dp = 8.dp) : Modifier =
    padding(
        start = size,
        end = size
    )



fun Modifier.roundedCornerShape(size: Dp = 5.dp) : Modifier =
    clip(RoundedCornerShape(size))

fun Modifier.roundedCornerShape(
    topStart: Dp = 5.dp,
    topEnd: Dp = 5.dp,
    bottomStart: Dp = 5.dp,
    bottomEnd: Dp = 5.dp
) : Modifier =
    clip(
        RoundedCornerShape(
            topStart = topStart,
            topEnd = topEnd,
            bottomStart = bottomStart,
            bottomEnd = bottomEnd
        )
    )

fun Modifier.bottomRoundedCornerShape(size: Dp = 5.dp) : Modifier =
    clip(
        RoundedCornerShape(
            bottomStart = size,
            bottomEnd = size
        )
    )

fun Modifier.defaultSpacerHeight(): Modifier =
    height(10.dp)

fun Modifier.defaultSpacerWidth(): Modifier =
    width(10.dp)