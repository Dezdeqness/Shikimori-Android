package com.dezdeqness.presentation.action

import com.dezdeqness.presentation.event.AnimeDetails
import com.dezdeqness.presentation.event.EventListener

class ActionConsumer {

    private var eventListener: EventListener? = null

    fun attachListener(eventListener: EventListener) {
        this.eventListener = eventListener
    }

    fun detachListener() {
        this.eventListener = null
    }
    fun consume(action: Action) {
        when (action) {
            is Action.AnimeClick -> {
                eventListener?.onEventReceive(AnimeDetails(animeId = action.animeId))
            }
        }
    }

}
