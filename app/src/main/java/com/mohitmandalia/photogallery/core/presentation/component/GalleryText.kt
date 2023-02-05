package com.mohitmandalia.photogallery.core.presentation.component

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/**
 *   Created by Mohit Mandalia
 */

@Composable
fun GalleryText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Start,
    style: TextStyle = MaterialTheme.typography.body1,
    fontSize: TextUnit = 14.sp,
    fontStyle: FontStyle = FontStyle.Normal,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: FontFamily = FontFamily.Serif
) {
    Text(
        text = text,
        textAlign = textAlign,
        color = color,
        style = style,
        fontSize = fontSize,
        modifier = modifier,
        fontFamily = fontFamily,
        fontStyle = fontStyle,
        fontWeight = fontWeight
    )
}