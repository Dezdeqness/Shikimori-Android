package com.dezdeqness.presentation.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AnimeSearchFilter(
    val innerId: String,
    val displayName: String,
    val items: List<AnimeCell>
) : Parcelable

@Parcelize
data class AnimeCell(
    val id: String,
    val displayName: String,
    var state: CellState = CellState.NONE,
) : Parcelable

data class AnimeCellList(
    val list: List<AnimeCell>
) : AdapterItem()

@Parcelize
enum class CellState : Parcelable {
    INCLUDE,
    EXCLUDE,
    NONE,
}
