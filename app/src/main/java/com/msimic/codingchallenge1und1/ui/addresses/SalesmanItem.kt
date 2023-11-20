package com.msimic.codingchallenge1und1.ui.addresses

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.msimic.codingchallenge1und1.data.model.Salesman
import com.msimic.codingchallenge1und1.ui.theme.CodingChallenge1und1Theme

@Composable
fun SalesmanItem(
    modifier: Modifier = Modifier,
    salesman: Salesman,
    isCollapsed: Boolean = false,
    onClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        FirstLetterIndicator(letter = salesman.name.first())

        DetailsSection(
            salesman = salesman,
            isCollapsed = isCollapsed,
        )
    }
}

@Composable
fun FirstLetterIndicator(
    letter: Char,
) {
    Box(
        modifier = Modifier
            .background(Color.LightGray, CircleShape)
            .size(42.dp)
            .clip(CircleShape)
    ) {
        Text(
            text = letter.toString(),
            modifier = Modifier.align(Alignment.Center),
            fontSize = 32.sp,
        )
    }
}

@Composable
fun DetailsSection(
    salesman: Salesman,
    isCollapsed: Boolean,
) {
    Column(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = salesman.name,
            fontSize = 16.sp,
        )
    }
}

@Preview
@Composable
fun SalesmanItemPreview() {
    CodingChallenge1und1Theme {
        SalesmanItem(
            salesman = Salesman(
                name = "Bart Simpson",
                areas = listOf("12345", "999*"),
            )
        )
    }
}