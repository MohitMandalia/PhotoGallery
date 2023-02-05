package com.mohitmandalia.photogallery.core.util

import java.util.*

/**
 *   Created by Mohit Mandalia
 */

fun String.displayAsTags(): List<String> {
    val tags = this.split(",").map {
        "#${it.replace(" ", "").trim()}"
    }
    return tags
}

fun String.capitalizeFirstChar(): String {
    return this.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(
            Locale.US
        ) else it.toString()
    }
}