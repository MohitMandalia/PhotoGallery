package com.mohitmandalia.photogallery.core.presentation.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.mohitmandalia.photogallery.ui.theme.LightBlue

/**
 *   Created by Mohit Mandalia
 */

@Composable
fun GalleryButton(
    onClick: () -> Unit,
    colors: ButtonColors = ButtonDefaults.buttonColors(LightBlue),
    elevation: ButtonElevation = ButtonDefaults.elevatedButtonElevation(3.dp),
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = { onClick() },
        elevation = elevation,
        colors = colors
    ) {
        content()
    }

}