package com.example.jpc_todo_list.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jpc_todo_list.feature_note.domain.util.OrderBy
import com.example.jpc_todo_list.feature_note.domain.util.OrderType
import com.example.jpc_todo_list.ui.theme.JpC_Todo_ListTheme

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    orderBy: OrderBy = OrderBy.Date(OrderType.Descending),
    onOrderChange: (OrderBy) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(1.dp)
                .fillMaxWidth()
        ) {
            DefaultRadioButton(text = "Name",
                selected = orderBy is OrderBy.Name,
                onSelect = {
                    onOrderChange(OrderBy.Name(orderBy.orderType))
                }
            )
            Spacer(modifier = Modifier.width(5.dp))

            DefaultRadioButton(text = "Date",
                selected = orderBy is OrderBy.Date,
                onSelect = {
                    onOrderChange(OrderBy.Date(orderBy.orderType))
                }
            )
            Spacer(modifier = Modifier.width(5.dp))

            DefaultRadioButton(text = "Color",
                selected = orderBy is OrderBy.Color,
                onSelect = {
                    onOrderChange(OrderBy.Color(orderBy.orderType))
                }
            )
        }
        Row (
            modifier = Modifier
                .padding(1.dp)
                .fillMaxWidth()
        ){
            DefaultRadioButton(text = "Ascending",
                selected = orderBy.orderType is OrderType.Ascending,
                onSelect = {
                    onOrderChange(orderBy.copy(OrderType.Ascending))
                }
            )
            Spacer(modifier = Modifier.width(5.dp))

            DefaultRadioButton(text = "Descending",
                selected = orderBy.orderType is OrderType.Descending,
                onSelect = {
                    onOrderChange(orderBy.copy(OrderType.Descending))
                }
            )
        }
    }
}
@Preview (showBackground = true)
@Composable
fun OrderSectionPreview() {
    JpC_Todo_ListTheme {
        OrderSection(onOrderChange = {OrderBy.Date(OrderType.Ascending)})
    }
}