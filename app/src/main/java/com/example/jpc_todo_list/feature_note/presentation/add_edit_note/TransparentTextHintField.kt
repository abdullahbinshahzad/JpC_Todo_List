package com.example.jpc_todo_list.feature_note.presentation.add_edit_note

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.jpc_todo_list.ui.theme.JpC_Todo_ListTheme

@Composable
fun TransparentTextHintField(
    text: String,
    hint: String,
    modifier: Modifier = Modifier,
    isHintVisible: Boolean = true,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = TextStyle(),
    singleLine: Boolean = false,
    onFocusChange: (FocusState) -> Unit
){
//    val basicTextFieldState by remember {
//        mutableStateOf(text)
//    }
    Box(
        modifier = modifier
    ){
        BasicTextField(
            value = text,
            onValueChange = onValueChange,
            singleLine = singleLine,
            textStyle = textStyle,
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged {
                    onFocusChange(it)
                }
        ) {
            if (isHintVisible) {
                Text(text = hint, style = textStyle, color = Color.DarkGray)
            }
        }
    }
}
@Preview
@Composable
fun TransparentTextHintFieldPreview(){
    JpC_Todo_ListTheme {
        TransparentTextHintField(text = "i am", hint = "enter i am", onValueChange = {
                                                                                     AddEditNoteEvent.EnteredTitle(it)
        }, onFocusChange = {
            AddEditNoteEvent.ChangeTitleFocus(it)
        })
    }
}