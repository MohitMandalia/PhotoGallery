package com.mohitmandalia.photogallery.galleryImage.gallerylist.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mohitmandalia.photogallery.R
import com.mohitmandalia.photogallery.core.presentation.component.GalleryCard
import com.mohitmandalia.photogallery.core.presentation.component.GalleryText
import com.mohitmandalia.photogallery.core.util.defaultPadding
import com.mohitmandalia.photogallery.core.util.defaultScreenPadding
import com.mohitmandalia.photogallery.core.util.defaultSpacerWidth

/**
 *   Created by Mohit Mandalia
 */

@Composable
fun GallerySearchBar(
    defaultText: String? = null,
    hint: String = "Search by keywords like \"fruits\"",
    onSearch: (String) -> Unit
) {

    val defaultSearchTerm = defaultText ?: ""
    val text = remember {
        mutableStateOf(defaultSearchTerm)
    }

    var isHintDisplayed by remember {
        mutableStateOf(text.value == "" && hint != "")
    }

    GalleryCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .defaultScreenPadding()
    ) {
        Row(
            modifier = Modifier
                .defaultPadding()
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(id = R.drawable.outline_search),
                contentDescription = "Search by keywords",
                modifier = Modifier.padding(
                    start = 5.dp
                )
            )

            Spacer(modifier = Modifier.defaultSpacerWidth())

            Box(modifier = Modifier.fillMaxWidth()) {
                BasicTextField(
                    value = text.value,
                    onValueChange = {
                        text.value = it
                        isHintDisplayed = it.trim().isEmpty()
                        onSearch(it)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                )
                if(isHintDisplayed) {
                    GalleryText(
                        text = hint,
                        color = Color.Gray
                    )
                }
            }

        }
    }
}