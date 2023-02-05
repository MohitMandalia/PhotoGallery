package com.mohitmandalia.photogallery.galleryImage.gallerylist.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohitmandalia.photogallery.core.util.Constants
import com.mohitmandalia.photogallery.core.util.Resource
import com.mohitmandalia.photogallery.galleryImage.common.domain.usecase.GetGalleryImagesUseCase
import com.mohitmandalia.photogallery.galleryImage.gallerylist.presentation.state.GalleryImageListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 *   Created by Mohit Mandalia
 */

@HiltViewModel
class GalleryListViewModel @Inject constructor(
    private val getGalleryImagesUseCase: GetGalleryImagesUseCase,
) : ViewModel() {

    private val _photoList = mutableStateOf(GalleryImageListState())
    val photoList: State<GalleryImageListState> = _photoList

    init {
        getPhotos()
    }

    fun getPhotos(query: String = Constants.DEFAULT_SEARCH_TERM) {
        getGalleryImagesUseCase(query).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _photoList.value = GalleryImageListState(galleryImages = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _photoList.value = GalleryImageListState(isLoading = true)
                }
                is Resource.Error -> {
                    _photoList.value = GalleryImageListState(error = result.message ?: "Unexpected Error")
                }
            }
        }.launchIn(viewModelScope)
    }
}