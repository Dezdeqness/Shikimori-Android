package com.dezdeqness.presentation.event

import com.dezdeqness.presentation.features.editrate.EditRateUiModel
import com.dezdeqness.presentation.models.AnimeSearchFilter
import java.util.*

sealed class Event {
    val id: String = UUID.randomUUID().toString()
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Event

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

}

sealed class ConsumableEvent : Event()

data class AnimeDetails(val animeId: Long) : ConsumableEvent()

data class ApplyFilter(val filters: List<AnimeSearchFilter> = listOf()) : Event()

data class NavigateToFilter(val filters: List<AnimeSearchFilter> = listOf()) : Event()

data class NavigateToSortFilter(val currentSort: String) : Event()

data class NavigateToEditRate(val rateId: Long) : Event()

data class EditUserRate(val userRateUiModel: EditRateUiModel) : Event()

object ScrollToTop : Event()