package com.msimic.codingchallenge1und1.ui.addresses

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msimic.codingchallenge1und1.data.repository.SalesmanRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class AddressesViewModel @Inject constructor(
    private val repository: SalesmanRepository,
) : ViewModel() {
    private val _query = MutableStateFlow("")
    val query = _query.asStateFlow()

    private var areaFilter = MutableStateFlow("")

    @OptIn(ExperimentalCoroutinesApi::class)
    val salesmen = areaFilter.flatMapMerge { areaFilter ->
        repository.getSalesmen(areaFilter)
    }

    init {
        viewModelScope.launch {
            val regex = Regex("^[0-9]{5}$|^[0-9]{1,4}\\*$")
            _query.debounce(1000L)
                .collectLatest { query ->
                    areaFilter.value = if (query.matches(regex)) query else ""
                }
        }
    }

    fun changeQuery(newQuery: String) {
        _query.value = newQuery
    }
}