package com.msimic.codingchallenge1und1.ui.addresses

import androidx.lifecycle.ViewModel
import com.msimic.codingchallenge1und1.data.repository.SalesmanRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddressesViewModel @Inject constructor(
    private val repository: SalesmanRepository,
) : ViewModel() {
}