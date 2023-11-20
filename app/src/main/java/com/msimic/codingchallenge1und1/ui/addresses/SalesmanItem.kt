package com.msimic.codingchallenge1und1.ui.addresses

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.msimic.codingchallenge1und1.data.model.Salesman
import com.msimic.codingchallenge1und1.ui.theme.CodingChallenge1und1Theme
import com.msimic.codingchallenge1und1.ui.theme.Grey200
import com.msimic.codingchallenge1und1.ui.theme.Grey400

@Composable
fun SalesmanItem(
    modifier: Modifier = Modifier,
    salesman: Salesman,
    isCollapsed: Boolean = true,
    onClick: () -> Unit = {},
) {
    var collapsed by remember { mutableStateOf(isCollapsed) }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick()
                collapsed = !collapsed
            }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        FirstLetterIndicator(letter = salesman.name.first())

        DetailsSection(
            salesman = salesman,
            isCollapsed = collapsed,
            modifier = modifier.weight(1f),
        )

        val isCollapsedImageVector =
            if (collapsed) Icons.Default.KeyboardArrowRight else Icons.Default.KeyboardArrowDown
        Icon(
            imageVector = isCollapsedImageVector,
            tint = Grey400,
            contentDescription = "Collapsed state item",
        )
    }
}

@Composable
fun FirstLetterIndicator(
    modifier: Modifier = Modifier,
    letter: Char,
) {
    Box(
        modifier = modifier
            .background(Grey200, CircleShape)
            .size(42.dp)
            .clip(CircleShape)
            .border(1.dp, color = Grey400, shape = CircleShape)
    ) {
        Text(
            text = letter.toString(),
            modifier = modifier.align(Alignment.Center),
            fontSize = 24.sp,
        )
    }
}

@Composable
fun DetailsSection(
    modifier: Modifier = Modifier,
    salesman: Salesman,
    isCollapsed: Boolean,
) {
    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = salesman.name,
            fontSize = 16.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        if (!isCollapsed) {
            Text(
                text = salesman.areasString,
                color = Grey400,
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Preview
@Composable
fun SalesmanItemCollapsedPreview() {
    CodingChallenge1und1Theme {
        SalesmanItem(
            salesman = Salesman(
                name = "Bart Simpson",
                areas = listOf("12345", "999*"),
            ),
            isCollapsed = true,
        )
    }
}

@Preview
@Composable
fun SalesmanItemExpandedPreview() {
    CodingChallenge1und1Theme {
        SalesmanItem(
            salesman = Salesman(
                name = "Bart Simpson",
                areas = listOf("12345", "999*"),
            ),
            isCollapsed = false,
        )
    }
}