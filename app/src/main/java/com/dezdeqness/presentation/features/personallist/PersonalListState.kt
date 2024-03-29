package com.dezdeqness.presentation.features.personallist

import com.dezdeqness.presentation.models.AdapterItem
import com.dezdeqness.presentation.models.RibbonStatusUiModel

data class PersonalListState(
    val ribbon: List<RibbonStatusUiModel> = listOf(),
    val items: List<AdapterItem> = listOf(),
    val isPullDownRefreshing: Boolean = false,
    val isInitialLoadingIndicatorShowing: Boolean = false,
    val isEmptyStateShowing: Boolean = false,
    val isScrollNeed: Boolean = false,
)
