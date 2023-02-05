package com.mohitmandalia.photogallery.galleryImage.common.data.mapper

import com.mohitmandalia.photogallery.galleryImage.common.data.network.dto.GalleryImageDto
import com.mohitmandalia.photogallery.galleryImage.common.data.network.dto.GalleryImagesDto
import com.mohitmandalia.photogallery.galleryImage.common.domain.model.GalleryImage

/**
 *   Created by Mohit Mandalia
 */

fun GalleryImageDto.toGalleryImages(): GalleryImage {
    return GalleryImage(
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

fun GalleryImagesDto.toGalleryImages(): List<GalleryImage> {
    return photos.map { it.toGalleryImages() }
}