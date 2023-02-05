package com.mohitmandalia.photogallery.galleryImage.common.data.mapper

import com.mohitmandalia.photogallery.galleryImage.common.data.local.datasource.model.GalleryImageEntity
import com.mohitmandalia.photogallery.galleryImage.common.domain.model.GalleryImage

/**
 *   Created by Mohit Mandalia
 */

fun GalleryImage.toGalleryEntity(): GalleryImageEntity {
    return GalleryImageEntity(
        collections = collections,
        comments = comments,
        downloads = downloads,
        id = id,
        imageHeight = imageHeight,
        imageSize = imageSize,
        imageWidth = imageWidth,
        largeImageURL = largeImageURL,
        likes = likes,
        pageURL = pageURL,
        previewHeight = previewHeight,
        previewURL = previewURL,
        previewWidth = previewWidth,
        tags = tags,
        type = type,
        user = user,
        userImageURL = userImageURL,
        userId = userId,
        views = views,
        webFormatHeight = webFormatHeight,
        webFormatURL = webFormatURL,
        webFormatWidth = webFormatWidth
    )
}