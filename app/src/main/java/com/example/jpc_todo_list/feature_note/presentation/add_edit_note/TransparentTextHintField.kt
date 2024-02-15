package com.example.jpc_todo_list.feature_note.presentation.add_edit_note

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun TransparentTextHintField(
    text: String,
    hint: String,
    onValueChange: (String) -> Unit,
    onFocusChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    isHintVisible: Boolean,
    textStyle: TextStyle,
    singleLine: Boolean = false,
){
    Box(modifier = modifier){
        BasicTextField(
            value = text,
            onValueChange = onValueChange,
            singleLine = singleLine,
            textStyle = textStyle,
            onFocus = {onFocusChange(true)},
            onBlur = {onFocusChange(false)},
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)

        ) {
            if (isHintVisible) {
                Text(text = hint, style = textStyle, color = Color.Gray, modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}