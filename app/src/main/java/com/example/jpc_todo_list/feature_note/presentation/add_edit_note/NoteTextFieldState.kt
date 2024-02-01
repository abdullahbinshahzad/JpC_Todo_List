package com.example.jpc_todo_list.feature_note.presentation.add_edit_note

data class NoteTextFieldState(
    val text: String = " ",
    val hint: String = " ",
    val isHintVisible: Boolean = true
)
