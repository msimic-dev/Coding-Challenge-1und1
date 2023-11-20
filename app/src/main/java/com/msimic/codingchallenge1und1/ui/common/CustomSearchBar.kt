package com.msimic.codingchallenge1und1.ui.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.msimic.codingchallenge1und1.ui.theme.CodingChallenge1und1Theme


@Composable
fun CustomSearchBar(
    modifier: Modifier = Modifier,
    query: String,
    onQueryChange: (String) -> Unit = {},
    placeholder: String = "Suche",
) {

    TextField(
        modifier = modifier,
        value = query,
        onValueChange = { newQuery ->
            onQueryChange(newQuery)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search for salesmen"
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Mic,
                contentDescription = "Record search query"
            )
        },
        placeholder = {
            Text(
                text = placeholder,
                fontSize = 16.sp,
            )
        }
    )
}

@Preview
@Composable
fun PreviewCustomSearchBarEmpty() {
    CodingChallenge1und1Theme {
        CustomSearchBar(query = "")
    }
}
