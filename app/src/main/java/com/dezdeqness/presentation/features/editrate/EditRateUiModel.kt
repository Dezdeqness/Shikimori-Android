package com.dezdeqness.presentation.features.editrate

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EditRateUiModel(
    val rateId: Long,
    val status: String,
    val episodes: Long,
    val score: Float,
) : Parcelable
