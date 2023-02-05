package com.mohitmandalia.photogallery.core.presentation.component

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import coil.transform.Transformation
import com.mohitmandalia.photogallery.R

/**
 *   Created by Mohit Mandalia
 */


@Composable
fun GalleryDisplayImage(
    imageUrl: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
    transformation: Transformation? = null,
) {
    val imageRequest = if(transformation != null) {
        ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .scale(Scale.FILL)
            .crossfade(true)
            .crossfade(500)
            .error(R.drawable.no_internet)
            .transformations(transformation)
            .build()
    } else {
        ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .scale(Scale.FILL)
            .error(R.drawable.no_internet)
            .crossfade(true)
            .crossfade(500)
            .build()
    }
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