package com.mohitmandalia.photogallery.galleryImage.gallerylist.presentation.component


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohitmandalia.photogallery.core.presentation.component.GalleryCard
import com.mohitmandalia.photogallery.core.presentation.component.GalleryDisplayImage
import com.mohitmandalia.photogallery.core.presentation.component.GalleryText
import com.mohitmandalia.photogallery.core.util.capitalizeFirstChar
import com.mohitmandalia.photogallery.core.util.defaultPadding
import com.mohitmandalia.photogallery.core.util.defaultSpacerHeight
import com.mohitmandalia.photogallery.core.util.displayAsTags
import com.mohitmandalia.photogallery.core.util.horizontalPadding
import com.mohitmandalia.photogallery.core.util.roundedCornerShape
import com.mohitmandalia.photogallery.galleryImage.common.domain.model.GalleryImage

/**
 *   Created by Mohit Mandalia
 */

@Composable
fun GalleryImageListItem(
    galleryImage: GalleryImage,
    onItemClick: (GalleryImage) -> Unit
) {

    GalleryCard(
        modifier = Modifier
            .defaultPadding()
            .width(200.dp)
            .height(270.dp)
            .clickable {
                onItemClick(galleryImage)
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentAlignment = Alignment.Center
            ) {
                GalleryDisplayImage(
                    imageUrl = galleryImage.largeImageURL,
                    contentDescription = galleryImage.type,
                    modifier = Modifier.roundedCornerShape(
                        topStart = 5.dp,
                        topEnd = 5.dp
                    )
                )
            }

            Column(
                modifier = Modifier.horizontalPadding()
            ) {

                Spacer(modifier = Modifier.defaultSpacerHeight())

                GalleryText(
                    text = galleryImage.user.capitalizeFirstChar(),
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(2.dp))

                Row(
                    modifier = Modifier.padding(vertical = 2.dp)
                ) {
                    (0 until 2).forEach {

                        val tag = galleryImage.tags.displayAsTags()[it]
                        GalleryText(
                            text = tag,
                            style = MaterialTheme.typography.caption,
                            fontFamily = FontFamily.Default,
                            color = Color.Gray,
                            fontSize = 12.sp
                        )

                        Spacer(modifier = Modifier.width(3.dp))
                    }
                }
            }
        }
    }

}