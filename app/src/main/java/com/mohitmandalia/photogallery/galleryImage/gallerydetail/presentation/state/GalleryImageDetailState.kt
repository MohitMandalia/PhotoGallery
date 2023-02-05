package com.mohitmandalia.photogallery.galleryImage.gallerydetail.presentation.state

import com.mohitmandalia.photogallery.galleryImage.common.domain.model.GalleryImage

/**
 *   Created by Mohit Mandalia
 */

data class GalleryImageDetailState(
    val isLoading: Boolean = false,
    val galleryImage: GalleryImage? = null
)
