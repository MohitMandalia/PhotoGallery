package com.mohitmandalia.photogallery.galleryImage.common.data.network.dto

import com.squareup.moshi.Json

data class GalleryImageDto(
    val collections: Int,
    val comments: Int,
    val downloads: Int,
    val id: Int,
    val imageHeight: Int,
    val imageSize: Int,
    val imageWidth: Int,
    val largeImageURL: String,
    val likes: Int,
    val pageURL: String,
    val previewHeight: Int,
    val previewURL: String,
    val previewWidth: Int,
    val tags: String,
    val type: String,
    val user: String,
    val userImageURL: String,
    @field:Json(name = "user_id")
    val userId: Int,
    val views: Int,
    @field:Json(name = "webformatHeight")
    val webFormatHeight: Int,
    @field:Json(name = "webformatURL")
    val webFormatURL: String,
    @field:Json(name = "webformatWidth")
    val webFormatWidth: Int
)