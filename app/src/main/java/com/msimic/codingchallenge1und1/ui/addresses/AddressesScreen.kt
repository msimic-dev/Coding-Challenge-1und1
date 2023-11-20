package com.msimic.codingchallenge1und1.ui.addresses

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.msimic.codingchallenge1und1.ui.theme.CodingChallenge1und1Theme
import com.msimic.codingchallenge1und1.ui.theme.Grey20

@Composable
fun AddressesScreen(
    viewModel: AddressesViewModel = hiltViewModel()
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize(),
    ) {
        val salesmen by viewModel.salesmen.collectAsState(initial = listOf())
        Column {
            Spacer(modifier = Modifier.height(64.dp))

            LazyColumn {
                items(items = salesmen) { salesman ->
                    SalesmanItem(salesman = salesman)
                    Divider(color = Grey20)
                }
            }
        }
    }
}

@Preview
@Composable
fun AddressesScreenPreview() {
    CodingChallenge1und1Theme {
        AddressesScreen()
    }
}