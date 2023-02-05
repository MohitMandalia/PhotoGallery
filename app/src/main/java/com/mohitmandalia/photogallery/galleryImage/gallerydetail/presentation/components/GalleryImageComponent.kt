package com.mohitmandalia.photogallery.galleryImage.gallerydetail.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.size.Size
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.mohitmandalia.photogallery.R
import com.mohitmandalia.photogallery.core.presentation.component.GalleryCard
import com.mohitmandalia.photogallery.core.presentation.component.GalleryDisplayImage
import com.mohitmandalia.photogallery.core.presentation.component.GalleryProfileImage
import com.mohitmandalia.photogallery.core.presentation.component.GalleryText
import com.mohitmandalia.photogallery.core.util.capitalizeFirstChar
import com.mohitmandalia.photogallery.core.util.defaultPadding
import com.mohitmandalia.photogallery.core.util.defaultSpacerHeight
import com.mohitmandalia.photogallery.core.util.defaultSpacerWidth
import com.mohitmandalia.photogallery.core.util.displayAsTags
import com.mohitmandalia.photogallery.galleryImage.common.domain.model.GalleryImage

/**
 *   Created by Mohit Mandalia
 */

@Composable
fun GalleryImageComponent(
    galleryImage: GalleryImage
) {

    val pixelSize = with(LocalDensity.current) {
        50.dp.toPx().toInt()
    }

    Column(
        modifier = Modifier
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        GalleryCard(
            modifier = Modifier
                .width(310.dp)
                .height(290.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                GalleryDisplayImage(
                    imageUrl = galleryImage.largeImageURL,
                    contentDescription = galleryImage.type,
                    transformation = RoundedCornersTransformation(
                        radius = 5f
                    )
                )
            }
        }

        Spacer(modifier = Modifier.defaultSpacerHeight())

        GalleryCard(
            modifier = Modifier
                .defaultPadding()
                .wrapContentHeight()
        ) {

            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .wrapContentHeight()
                    .fillMaxWidth()
            ) {

                Row(
                    modifier = Modifier
                        .defaultPadding()
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp)
                    ) {
                        GalleryProfileImage(
                            imageUrl = galleryImage.userImageURL,
                            contentDescription = galleryImage.user,
                            transformation = CircleCropTransformation(),
                            size = Size(
                                width = pixelSize,
                                height = pixelSize
                            )
                        )
                    }

                    Spacer(modifier = Modifier.defaultSpacerWidth())

                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {
                        GalleryText(
                            text = galleryImage.user.capitalizeFirstChar(),
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(2.dp))

                        Row {
                            galleryImage.tags.displayAsTags().forEach { tag ->
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

                Spacer(modifier = Modifier.height(2.dp))

                Divider()

                Spacer(modifier = Modifier.height(3.dp))

                Row(
                    modifier = Modifier
                        .defaultPadding(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.outline_like_gray),
                        contentDescription = "Like"
                    )

                    Spacer(modifier = Modifier.defaultSpacerWidth())


                    GalleryText(
                        text = galleryImage.likes.toString(),
                        color = Color.Gray,
                        modifier = Modifier.weight(1f)
                    )

                    Spacer(modifier = Modifier.defaultSpacerWidth())

                    Icon(
                        painter = painterResource(id = R.drawable.outline_comment_gray),
                        contentDescription = "Comment"
                    )

                    Spacer(modifier = Modifier.defaultSpacerWidth())

                    GalleryText(
                        text = galleryImage.comments.toString(),
                        modifier = Modifier.weight(1f),
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.defaultSpacerWidth())

                    Icon(
                        painter = painterResource(id = R.drawable.outline_download_gray),
                        contentDescription = "Download"
                    )

                    Spacer(modifier = Modifier.defaultSpacerWidth())

                    GalleryText(
                        text = galleryImage.downloads.toString(),
                        color = Color.Gray,
                        modifier = Modifier.weight(1f)
                    )
                }

            }

        }
    }

}