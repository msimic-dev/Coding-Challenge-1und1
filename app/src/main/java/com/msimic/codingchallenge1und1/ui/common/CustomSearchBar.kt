package com.msimic.codingchallenge1und1.ui.common

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.msimic.codingchallenge1und1.ui.theme.CodingChallenge1und1Theme
import com.msimic.codingchallenge1und1.ui.theme.Grey400


@Composable
fun CustomSearchBar(
    modifier: Modifier = Modifier,
    query: String,
    onQueryChange: (String) -> Unit = {},
    placeholder: String = "Suche",
) {
    val focusManager = LocalFocusManager.current

    TextField(
        modifier = modifier
            .shadow(1.dp),
        value = query,
        onValueChange = { newQuery ->
            onQueryChange(newQuery)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                tint = Grey400,
                contentDescription = "Search for salesmen"
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Mic,
                tint = Grey400,
                contentDescription = "Record search query"
            )
        },
        placeholder = {
            Text(
                text = placeholder,
                fontSize = 16.sp,
                color = Grey400,
            )
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch = {
                focusManager.clearFocus()
            }
        ),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White,
        )
    )
}

@Preview
@Composable
fun PreviewCustomSearchBarEmpty() {
    CodingChallenge1und1Theme {
        CustomSearchBar(query = "")
    }
}

@Preview
@Composable
fun PreviewCustomSearchBarSearch() {
    CodingChallenge1und1Theme {
        CustomSearchBar(query = "92109")
    }
}