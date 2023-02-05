package com.mohitmandalia.photogallery.galleryImage.common.domain.usecase

import com.mohitmandalia.photogallery.core.dispatcher.StandardDispatchers
import com.mohitmandalia.photogallery.galleryImage.common.domain.repository.GalleryImageRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 *   Created by Mohit Mandalia
 */

class GetGalleryImagesUseCase @Inject constructor(
    private val repository: GalleryImageRepository,
    private val dispatchers: StandardDispatchers
) {
    operator fun invoke(query: String) = flow {
        val photos = repository.getGalleryImages(query)
        emit(photos)
    }.flowOn(dispatchers.io)
}