package com.mohitmandalia.photogallery.galleryImage.gallerylist.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mohitmandalia.photogallery.R
import com.mohitmandalia.photogallery.core.presentation.component.GalleryAlertDialog
import com.mohitmandalia.photogallery.core.presentation.component.GalleryText
import com.mohitmandalia.photogallery.core.presentation.component.SetStatusBar
import com.mohitmandalia.photogallery.core.util.capitalizeFirstChar
import com.mohitmandalia.photogallery.core.util.defaultPadding
import com.mohitmandalia.photogallery.core.util.defaultSpacerHeight
import com.mohitmandalia.photogallery.galleryImage.common.domain.model.GalleryImage
import com.mohitmandalia.photogallery.galleryImage.gallerylist.presentation.component.GalleryImageListDialogContent
import com.mohitmandalia.photogallery.navigation.Screen
import com.mohitmandalia.photogallery.galleryImage.gallerylist.presentation.component.GalleryImageListItem
import com.mohitmandalia.photogallery.galleryImage.gallerylist.presentation.component.GallerySearchBar
import com.mohitmandalia.photogallery.galleryImage.gallerylist.presentation.viewmodel.GalleryListViewModel

/**
 *   Created by Mohit Mandalia
 */

@Composable
fun GalleryImageListScreen(
    navController: NavController,
    viewModel: GalleryListViewModel = hiltViewModel()
) {
    SetStatusBar()

    val state = viewModel.photoList.value
    val dialogState = remember {
        mutableStateOf(false)
    }

    val selectedItem = remember {
        mutableStateOf<GalleryImage?>(null)
    }

    if(dialogState.value) {
        GalleryAlertDialog(
            onDismissRequest = { dialogState.value = false },
            buttons = {
                selectedItem.value?.let { item ->
                    val user = item.user.capitalizeFirstChar()
                    GalleryImageListDialogContent(
                        onNegativeButtonClicked = {
                            dialogState.value = false
                        },
                        onPositiveButtonClicked = {
                            dialogState.value = false
                            navController.navigate(
                                Screen.GalleryImageDetailScreen.route + "/${item.id}"
                            )
                        },
                        positiveText = "Yes",
                        negativeText = "No",
                        content = "Do you want to view details about \"${"$user's"}\" image?"
                    )
                }
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        GallerySearchBar(
            onSearch = {
                viewModel.getPhotos(
                    query = it
                )
            }
        )


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 16.dp,
                    vertical = 2.dp
                )
        ) {

            if(state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            if(state.error != null) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .defaultPadding()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.no_internet),
                        contentDescription = "No Internet"
                    )

                    Spacer(modifier = Modifier.defaultSpacerHeight())

                    GalleryText(
                        text = state.error,
                        color = Color.Gray
                    )
                }
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                items(state.galleryImages) { galleryImage ->

                    GalleryImageListItem(
                        galleryImage = galleryImage,
                        onItemClick = { item ->
                            dialogState.value = true
                            selectedItem.value = item
                        }
                    )
                }
            }
        }
    }

}