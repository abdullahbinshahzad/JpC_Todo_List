package com.example.jpc_todo_list.feature_note.presentation.notes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                .padding(4.dp)
                .fillMaxWidth()
                .background(Color.LightGray, shape = CutCornerShape(5.dp)),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            DefaultRadioButton(text = "Name",
                selected = orderBy is OrderBy.Name,
                onSelect = {
                    onOrderChange(OrderBy.Name(orderBy.orderType))
                }
            )

            DefaultRadioButton(text = "Date",
                selected = orderBy is OrderBy.Date,
                onSelect = {
                    onOrderChange(OrderBy.Date(orderBy.orderType))
                }
            )

            DefaultRadioButton(text = "Color",
                selected = orderBy is OrderBy.Color,
                onSelect = {
                    onOrderChange(OrderBy.Color(orderBy.orderType))
                }
            )
        }
        Row (
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .background(Color.LightGray, shape = CutCornerShape(5.dp)),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            DefaultRadioButton(text = "Ascending",
                selected = orderBy.orderType is OrderType.Ascending,
                onSelect = {
                    onOrderChange(orderBy.copy(OrderType.Ascending))
                }
            )

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