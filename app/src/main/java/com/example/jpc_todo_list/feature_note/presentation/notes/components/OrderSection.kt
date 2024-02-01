package com.example.jpc_todo_list.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jpc_todo_list.feature_note.domain.util.OrderBy
import com.example.jpc_todo_list.feature_note.domain.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    orderBy: OrderBy = OrderBy.Date(OrderType.Descending),
    onOrderChange: Any
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
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
            modifier = Modifier.fillMaxSize()
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