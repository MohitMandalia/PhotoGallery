package com.mohitmandalia.photogallery.galleryImage.gallerydetail.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.mohitmandalia.photogallery.core.presentation.component.SetStatusBar
import com.mohitmandalia.photogallery.galleryImage.gallerydetail.presentation.components.GalleryImageComponent
import com.mohitmandalia.photogallery.galleryImage.gallerydetail.presentation.viewmodel.GalleryImageDetailViewModel

/**
 *   Created by Mohit Mandalia
 */

@Composable
fun GalleryImageDetailScreen(
    viewModel: GalleryImageDetailViewModel = hiltViewModel()
) {

    SetStatusBar()
    
    val state = viewModel.galleryImageState.value

    state.galleryImage?.let { galleryImage ->
        GalleryImageComponent(galleryImage = galleryImage)
    }
}
