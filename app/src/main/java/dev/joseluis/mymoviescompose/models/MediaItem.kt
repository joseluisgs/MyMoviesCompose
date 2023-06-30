package dev.joseluis.mymoviescompose.models

import dev.joseluis.mymoviescompose.models.MediaItem.Type.PHOTO
import dev.joseluis.mymoviescompose.models.MediaItem.Type.VIDEO

data class MediaItem(
    val id: Int,
    val title: String,
    val thumb: String,
    val type: Type,
) {
    enum class Type {
        PHOTO, VIDEO
    }
}

fun getMediaItems() = (1..10).map {
    MediaItem(
        id = it,
        title = "Title $it",
        thumb = "https://loremflickr.com/400/400/cat?lock=$it",
        type = if (it % 3 == 0) VIDEO else PHOTO
    )
}


