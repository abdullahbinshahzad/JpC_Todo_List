package com.example.jpc_todo_list.feature_note.presentation.add_edit_note

sealed class AddEditNoteEvent {
    data class EnteredTitle (val value: String): AddEditNoteEvent()
    data class ChangeTitleFocus(val focusState: Boolean): AddEditNoteEvent()
    data class EnteredContent (val value: String): AddEditNoteEvent()
    data class ChangeContentFocus (val focusState: Boolean): AddEditNoteEvent()
    data class ChangeColor (val color: Int): AddEditNoteEvent()
    object SaveNote: AddEditNoteEvent()
}