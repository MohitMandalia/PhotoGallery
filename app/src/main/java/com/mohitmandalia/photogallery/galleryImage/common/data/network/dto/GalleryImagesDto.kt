package com.mohitmandalia.photogallery.galleryImage.common.data.network.dto

import com.squareup.moshi.Json

data class GalleryImagesDto(
    @field:Json(name = "hits")
    val photos: List<GalleryImageDto>,
    val total: Int,
    val totalHits: Int
)