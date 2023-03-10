package com.mohitmandalia.photogallery.core.presentation.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 *   Created by Mohit Mandalia
 */

@Composable
fun GalleryCard(
    modifier: Modifier = Modifier,
    elevation: CardElevation = CardDefaults.cardElevation(3.dp),
    colors: CardColors = CardDefaults.cardColors(
        containerColor = Color.White
    ),
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier,
        elevation = elevation,
        colors = colors
    ) {
        content()
    }
}