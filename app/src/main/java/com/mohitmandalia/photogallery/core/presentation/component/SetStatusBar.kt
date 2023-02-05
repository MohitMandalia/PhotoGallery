package com.mohitmandalia.photogallery.core.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/**
 *   Created by Mohit Mandalia
 */

@Composable
fun SetStatusBar(
    color: Color = Color.White
) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = color
        )
    }
}