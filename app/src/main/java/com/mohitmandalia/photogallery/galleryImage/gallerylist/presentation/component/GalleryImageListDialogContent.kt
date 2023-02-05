package com.mohitmandalia.photogallery.galleryImage.gallerylist.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mohitmandalia.photogallery.core.presentation.component.GalleryButton
import com.mohitmandalia.photogallery.core.presentation.component.GalleryText
import com.mohitmandalia.photogallery.core.util.defaultScreenPadding
import com.mohitmandalia.photogallery.core.util.defaultSpacerHeight
import com.mohitmandalia.photogallery.core.util.defaultSpacerWidth
import com.mohitmandalia.photogallery.core.util.horizontalPadding

/**
 *   Created by Mohit Mandalia
 */

@Composable
fun GalleryImageListDialogContent(
    content: String,
    positiveText: String,
    negativeText: String,
    onNegativeButtonClicked: () -> Unit,
    onPositiveButtonClicked: () -> Unit
) {

    Column(
        modifier = Modifier.defaultScreenPadding()
    ) {
        GalleryText(
            text = content
        )

        Spacer(modifier = Modifier.defaultSpacerHeight())

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalPadding(3.dp),
            horizontalArrangement = Arrangement.End
        ) {
            GalleryButton(
                onClick = {
                    onPositiveButtonClicked()
                }
            ) {
                GalleryText(
                    text = positiveText
                )
            }

            Spacer(modifier = Modifier.defaultSpacerWidth())

            GalleryButton(
                onClick = {
                    onNegativeButtonClicked()
                },
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                GalleryText(
                    text = negativeText
                )
            }
        }
    }

}