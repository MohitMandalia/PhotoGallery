package com.mohitmandalia.photogallery.galleryImage.gallerylist.presentation.state

import com.mohitmandalia.photogallery.galleryImage.common.domain.model.GalleryImage

/**
 *   Created by Mohit Mandalia
 */
data class GalleryImageListState(
    val isLoading: Boolean = false,
    val galleryImages: List<GalleryImage> = emptyList(),
    val error: String? = null
)
