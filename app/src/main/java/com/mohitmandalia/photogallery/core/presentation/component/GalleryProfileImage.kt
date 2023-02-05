package com.mohitmandalia.photogallery.core.presentation.component

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import coil.size.Size
import coil.transform.Transformation

/**
 *   Created by Mohit Mandalia
 */

@Composable
fun GalleryProfileImage(
    imageUrl: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
    transformation: Transformation,
    size: Size
) {
    val imageRequest = ImageRequest.Builder(LocalContext.current)
        .data(imageUrl)
        .scale(Scale.FILL)
        .transformations(transformation)
        .size(size)
        .crossfade(true)
        .crossfade(500)
        .build()
    SubcomposeAsyncImage(
        model = imageRequest,
        contentDescription = contentDescription,
        modifier = modifier,
        loading = {
            CircularProgressIndicator()
        },
        contentScale = ContentScale.Crop
    )
}