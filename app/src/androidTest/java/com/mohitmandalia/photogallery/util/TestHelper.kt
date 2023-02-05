package com.mohitmandalia.photogallery.util

import com.mohitmandalia.photogallery.galleryImage.common.data.local.datasource.model.GalleryImageEntity
import com.mohitmandalia.photogallery.galleryImage.common.data.mapper.toGalleryEntity
import com.mohitmandalia.photogallery.galleryImage.common.domain.model.GalleryImage
import java.util.*
import kotlin.random.Random

/**
 *   Created by Mohit Mandalia
 */
object TestHelper {

    fun generateTestGalleryImages(): List<GalleryImage> {
        val galleryImage = generateTestGalleryImage()
        return listOf(
            galleryImage
        )
    }

    fun generateTestGalleryImage(
        id: Int = randomInt()
    ): GalleryImage {
        return GalleryImage(
            collections = randomInt(),
            comments = randomInt(),
            downloads = randomInt(),
            id = id,
            imageHeight = randomInt(),
            imageSize = randomInt(),
            imageWidth = randomInt(),
            largeImageURL = randomString(),
            likes = randomInt(),
            pageURL = randomString(),
            previewHeight = randomInt(),
            previewURL = randomString(),
            previewWidth = randomInt(),
            tags = "${randomString()}, ${randomString()}",
            type = randomString(),
            user = randomString(),
            userImageURL = randomString(),
            userId = randomInt(),
            views = randomInt(),
            webFormatHeight = randomInt(),
            webFormatURL = randomString(),
            webFormatWidth = randomInt()
        )
    }

    fun generateGalleryImageEntity(id: Int = randomInt()): GalleryImageEntity {
        return generateTestGalleryImage(id).toGalleryEntity()
    }

    fun generateGalleryImageEntities(): List<GalleryImageEntity> {
        return generateTestGalleryImages().map { it.toGalleryEntity() }
    }

    fun randomString(): String {
        return UUID.randomUUID().toString()
    }

    fun randomInt(from: Int = Int.MIN_VALUE, until: Int = Int.MAX_VALUE): Int {
        return Random.nextInt(
            from = from,
            until = until
        )
    }

}