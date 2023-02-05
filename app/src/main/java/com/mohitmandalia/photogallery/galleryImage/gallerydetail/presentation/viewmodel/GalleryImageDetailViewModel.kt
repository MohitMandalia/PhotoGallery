package com.mohitmandalia.photogallery.galleryImage.gallerydetail.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohitmandalia.photogallery.galleryImage.common.domain.usecase.GetGalleryImageByIdUseCase
import com.mohitmandalia.photogallery.galleryImage.gallerydetail.presentation.state.GalleryImageDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 *   Created by Mohit Mandalia
 */

@HiltViewModel
class GalleryImageDetailViewModel @Inject constructor(
    val getGalleryImageByIdUseCase: GetGalleryImageByIdUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _galleryImageState = mutableStateOf(GalleryImageDetailState())
    val galleryImageState: State<GalleryImageDetailState> = _galleryImageState

    init{
        savedStateHandle.get<Int>("id")?.let { id ->
            getGalleryImageById(id)
        }
    }

    private fun getGalleryImageById(id: Int) {
        _galleryImageState.value = GalleryImageDetailState(isLoading = true)
        getGalleryImageByIdUseCase(id).onEach { galleryImage ->
            _galleryImageState.value = GalleryImageDetailState(galleryImage = galleryImage)
        }.launchIn(viewModelScope)
    }

}