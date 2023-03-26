package com.dezdeqness.presentation.features.personallist

import com.dezdeqness.core.DelegateAdapter
import com.dezdeqness.presentation.action.ActionListener
import com.dezdeqness.presentation.features.personallist.recyclerview.personalListFilterAdapterDelegate
import com.dezdeqness.presentation.features.personallist.recyclerview.userRateAnimeAdapterDelegate
import com.dezdeqness.presentation.models.AdapterItem

class PersonalListAdapter(
    actionListener: ActionListener,
    onSortClicked: (String) -> Unit,
    onOrderClicked: (Boolean) -> Unit,
    onEditRateClicked: (Long) -> Unit,
) : DelegateAdapter<AdapterItem>(
    adapterDelegateList = listOf(
        userRateAnimeAdapterDelegate(
            actionListener = actionListener,
            onEditRateClicked = onEditRateClicked,
        ),
        personalListFilterAdapterDelegate(
            onSortClicked = onSortClicked,
            onOrderClicked = onOrderClicked,
        )
    ),
)