package com.msimic.codingchallenge1und1.ui.addresses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msimic.codingchallenge1und1.data.repository.SalesmanRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class AddressesViewModel @Inject constructor(
    private val repository: SalesmanRepository,
) : ViewModel() {
    val salesmen = repository.getSalesmen()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = listOf(),
        )
}